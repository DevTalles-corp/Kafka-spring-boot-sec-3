package com.bistro.reservations.service;

import com.bistro.reservations.controller.ReservationMapper;
import com.bistro.reservations.controller.ReservationRequest;
import com.bistro.reservations.controller.ReservationResponse;
import com.bistro.reservations.controller.ReservationStatusResponse;
import com.bistro.reservations.model.Reservation;
import com.bistro.reservations.model.ReservationCreated;
import com.bistro.reservations.model.ReservationStatus;
import com.bistro.reservations.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final KafkaTemplate<String, ReservationCreated> kafkaTemplate;
    private final ReservationMapper reservationMapper;

    @Transactional
    public ReservationResponse createReservation(ReservationRequest request) {
        Reservation reservation = reservationMapper.toEntity(request);
        reservation.setReservationCode(generateUniqueReservationCode());
        reservation.setStatus(ReservationStatus.PENDING);

        Reservation saved = reservationRepository.save(reservation);

        ReservationCreated event = new ReservationCreated(
                saved.getId(),
                saved.getPartySize(),
                LocalDateTime.now());

        kafkaTemplate.send("reservation-created", String.valueOf(saved.getId()), event);

        return reservationMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public ReservationStatusResponse getReservationStatus(String reservationCode) {
        Reservation reservation = reservationRepository.findByReservationCode(reservationCode)
                .orElseThrow(() -> new ReservationNotFoundException(reservationCode));
        return reservationMapper.toStatusResponse(reservation);
    }

    private String generateUniqueReservationCode() {
        String code;
        do {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            String uuid = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            code = "RES-" + date + "-" + uuid;
        } while (reservationRepository.findByReservationCode(code).isPresent());
        return code;
    }
}

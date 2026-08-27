package com.bistro.tables.service;

import com.bistro.reservations.model.ReservationCreated;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ReservationCreatedListener {

    private final TableService tableService;

    @KafkaListener(topics = "reservation-created" , groupId = "tables")
    public void onReservationCreated(ReservationCreated event){

        tableService.assignTableFor(event.partySize()).ifPresentOrElse(
                table -> log.info("Reserva {} → mesa {} ({} lugares) asignada",
                        event.reservationId(), table.getTableNumber(), table.getCapacity()),

                () -> log.info("Reserva {} → sin mesa para {} personas",
                        event.reservationId(), event.partySize()));
    }
}














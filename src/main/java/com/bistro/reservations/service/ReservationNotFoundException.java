package com.bistro.reservations.service;

public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException(String reservationCode) {
        super("No se encontró la reserva con código: " + reservationCode);
    }
}

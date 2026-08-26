package com.bistro.reservations.model;

import java.time.LocalDateTime;

public record ReservationCreated(
        Long reservationId,
        Integer partySize,
        LocalDateTime occurredAt
) {
}

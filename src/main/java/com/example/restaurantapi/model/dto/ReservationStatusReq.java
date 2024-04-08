package com.example.restaurantapi.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationStatusReq {
    private Long identifierReservation;
    private Long identifierRestaurant;
    private boolean isConfirmedByHost;
    private boolean isRejectedByHost;
}

package com.example.restaurantapi.model.dto;

import com.example.restaurantapi.model.entity.RestaurantModel;
import jakarta.persistence.Column;
import lombok.Builder;
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

package com.example.restaurantapi.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ReservationReq {
    private String guestName;

    private String guestSurname;

    private String guestPhoneNumber;
    private LocalDateTime reservationDate;

    private boolean isPrebookedByClient;

    private boolean isConfirmedByHost;

    private boolean isRejectedByHost;

    private String comments;

}

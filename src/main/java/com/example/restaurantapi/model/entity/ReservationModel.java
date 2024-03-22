package com.example.restaurantapi.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "GUEST_NAME", nullable = false)
    private String guestName;
    @Column(name = "GUEST_SURNAME")
    private String guestSurname;
    @Column(name = "GUEST_PHONENUMBER")
    private String guestPhoneNumber;
    @Column(name = "RESERVATION_DATE")
    private LocalDateTime reservationDate;

    @Column(name = "PREBOOKED_BY_CLIENT")
    private boolean isPrebookedByClient;

    @Column(name = "CONFIRMED_BY_HOST")
    private boolean isConfirmedByHost;

    @Column(name = "REJECTED_BY_HOST")
    private boolean isRejectedByHost;

    @Column(name = "COMMENTS")
    private String comments;


}

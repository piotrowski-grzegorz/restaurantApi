package com.example.restaurantapi.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "RESERVATION")
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "GUEST_NAME", nullable = false)
    private String guestName;

    @Column(name = "GUEST_SURNAME")
    private String guestSurname;

    @Column(name = "GUEST_PHONENUMBER")
    private String guestPhoneNumber;

    @Column(name = "RESERVATION_DATE")
    private LocalDateTime date;

    @Column(name = "CONFIRMED_BY_HOST")
    private boolean isConfirmedByHost;

    @Column(name = "REJECTED_BY_HOST")
    private boolean isRejectedByHost;

    @Column(name = "COMMENTS")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "id")
    @JsonBackReference
    private RestaurantModel restaurantModel;


}

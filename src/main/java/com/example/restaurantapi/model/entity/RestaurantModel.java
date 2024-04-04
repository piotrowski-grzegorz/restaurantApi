package com.example.restaurantapi.model.entity;

import com.example.restaurantapi.model.AddressModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "RESTAURANT")
public class RestaurantModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(name = "NAME", unique = false, nullable = false)
    private String name;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "OPEN_HOUR", length = 6, nullable = false)
    private String openHour;
    @Column(name = "CLOSE_HOUR", length = 6, nullable = false)
    private String closeHour;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RatingModel> rating;

    @Column(name = "AVG_MARK")
    private Double averageMark;

//    private PhotoModel photos;

//    @Column(name = "REVIEW_NUMBER")
//    private Integer reviewNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private AddressModel address;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TableModel> tables;

    @OneToMany(mappedBy = "restaurantModel", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference
    private List<ReservationModel> reservationModel;



}

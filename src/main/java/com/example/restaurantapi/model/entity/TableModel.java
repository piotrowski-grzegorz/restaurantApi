package com.example.restaurantapi.model.entity;

import com.example.restaurantapi.model.entity.RestaurantModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "TABLES")
public class TableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "SEATS_NUMBERS")
    private Integer seatsNumbers;

    @Column(name = "VISIBLE_FOR_CLIENT")
    private boolean isVisibleForClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "id")
    @JsonBackReference
    private RestaurantModel restaurant;

}

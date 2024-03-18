package com.example.restaurantapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RESTAURANT")
public class RestaurantModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME", unique = false, nullable = false)
    String name;
    @Column(name = "TYPE")
    String type;
    @Column(name = "OPEN_HOUR", length = 6, nullable = false)
    String openHour;
    @Column(name = "CLOSE_HOUR", length = 6, nullable = false)
    String closeHour;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    AddressModel address;


}

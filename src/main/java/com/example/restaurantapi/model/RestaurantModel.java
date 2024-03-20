package com.example.restaurantapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

//@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
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

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressModel address;


}

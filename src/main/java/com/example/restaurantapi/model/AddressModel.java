package com.example.restaurantapi.model;

import com.example.restaurantapi.model.entity.RestaurantModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Table(name = "ADDRESS")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "STREET", length = 128)
    private String streetName;
    @Column(name = "BUILDING_NUMBER", length = 128)
    private String buildingNumber;
    @Column(name = "APARTMENT_NUMBER", length = 128)
    private String apartmentNumber;
    @Column(name = "POSTAL_CODE", length = 128)
    private String postalCode;
    @Column(name = "CITY", length = 128)
    private String city;
    @Column(name = "COUNTRY", length = 128)
    private String country;

    @OneToOne
    @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "ID")
    @JsonBackReference
    private RestaurantModel restaurantModel;

}

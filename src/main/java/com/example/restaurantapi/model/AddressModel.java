package com.example.restaurantapi.model;

import com.example.restaurantapi.model.entity.RestaurantModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Data
@Table(name = "ADDRESS")
//@Embeddable
@Entity
public class AddressModel {
    public AddressModel(String streetName, String buildingNumber, String apartmentNumber, String postalCode, String city, String country) {
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

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

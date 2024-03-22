package com.example.restaurantapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
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
}

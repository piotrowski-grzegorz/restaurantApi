package com.example.restaurantapi.dto;

import com.example.restaurantapi.model.AddressModel;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NewRestaurantReq {
    private String name;
    private String type;
    private String closeHour;
    private String openHour;
    @Embedded
    private AddressModel address;

}

package com.example.restaurantapi.model.dto;

import com.example.restaurantapi.model.AddressModel;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NewRestaurantReq {
    @NotBlank(message = "Name of the restaurant is required")
    private String name;
    @NotBlank(message = "Type of the restaurant is required")
    private String type;
    @NotBlank(message = "Close hour is required")
    private String closeHour;
    @NotBlank(message = "Open hour is required")
    private String openHour;

    @Embedded
    private AddressModel address;

}

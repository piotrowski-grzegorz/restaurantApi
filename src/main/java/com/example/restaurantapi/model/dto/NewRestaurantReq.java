package com.example.restaurantapi.model.dto;

import com.example.restaurantapi.model.AddressModel;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NewRestaurantReq {
    @NotBlank(message = "Invalid Name: Empty name")
    @NotNull(message = "Invalid Name: Name is NULL")
    private String name;
    @NotBlank(message = "Invalid Type: Type of cuisine is empty")
    @NotNull(message = "Invalid Type: Type of cuisine is null")
    private String type;
    @NotBlank(message = "Invalid CloseHour: Close hour is empty")
    @NotNull(message = "Invalid CloseHour: Close hour is null")
    private String closeHour;
    @NotBlank(message = "Invalid OpenHour: Open hour is empty")
    @NotNull(message = "Invalid OpenHour: Open hour is null")
    private String openHour;

    @Embedded
    private AddressModel address;

}

package com.example.restaurantapi.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantReqDto {
    @NotBlank(message = "Name of the restaurant is required")
    private String name;
    @NotBlank(message = "Type of the restaurant is required")
    private String type;
    @NotBlank(message = "Close hour is required")
    private String openHour;
    @NotBlank(message = "Open hour is required")
    private String closeHour;
}

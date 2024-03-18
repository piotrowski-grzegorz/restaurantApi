package com.example.restaurantapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestaurantRedDto {
    @NotBlank(message = "Name is required")
    public String name;
    @NotBlank(message = "Type hour is required")
    public String type;


}

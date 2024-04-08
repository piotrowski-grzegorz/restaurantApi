package com.example.restaurantapi.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewMarkReq {
    @NotBlank(message = "Invalid Name: Empty name")
    @NotNull(message = "Invalid Name: Name is NULL")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
    private String name;

    @NotBlank(message = "Invalid Surname: Empty surname")
    @NotNull(message = "Invalid Surname: Surname is NULL")
    @Size(min = 3, max = 30, message = "Invalid Surname: Must be of 3 - 30 characters")
    private String surname;

    @Min(value = 1, message = "Invalid Mark: Equals to 0 or less than zero")
    @Max(value = 5, message = "Invalid Mark: Exceeds 5")
    private Integer mark;
    private String review;
}

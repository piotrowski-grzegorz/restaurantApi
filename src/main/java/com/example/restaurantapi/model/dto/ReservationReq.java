package com.example.restaurantapi.model.dto;

import com.example.restaurantapi.model.entity.RestaurantModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
public class ReservationReq {
    @NotBlank(message = "Invalid Name: Guest name is empty")
    @NotNull(message = "Invalid Name: Guest name null")
    @Size(min = 3, max = 100, message = "Invalid gustName: Name should be between 3-21 signs")
    private String guestName;
    @NotBlank(message = "Invalid Surname: Guest surname is empty")
    @NotNull(message = "Invalid Surname: Guest surname null")
    @Size(min = 3, max = 100, message = "Invalid gustName: Surname should be between 3-51 signs")
    private String guestSurname;
    @NotBlank(message = "Invalid PhoneNumber: PhoneNumber name is empty")
    @NotNull(message = "Invalid PhoneNumber: PhoneNumber name null")
//    @Max(value = 15, message = "Invalid PhoneNumber: PhoneNumber is too long")
    @Pattern(regexp = "\\d{9}", message = "Invalid PhoneNumber: Invalid format for phone number. Should be e.g 666555444")
    private String guestPhoneNumber;
//    @Pattern(regexp = "yyyy-MM-dd'T'HH:mm:ss", message = "Invalid Date: Invalid date format should be yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime date;

//    private boolean isPrebookedByClient;
//
//    private boolean isConfirmedByHost;
//
//    private boolean isRejectedByHost;


    @Size(min = 0, max = 100, message = "Invalid Comments: Text should be between 0-100 signs")
    private String comments;

//    private Long restaurantModelId;

}

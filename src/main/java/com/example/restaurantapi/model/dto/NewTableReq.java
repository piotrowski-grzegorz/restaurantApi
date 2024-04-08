package com.example.restaurantapi.model.dto;

import com.example.restaurantapi.utils.validator.ExpectedNumbers;
import lombok.Data;

@Data
public class NewTableReq {
    @ExpectedNumbers(expectedNumbers = { 2, 4, 6 }, message = "Invalid seatsNumber: number of seats should be 2,4 or 6")
    Integer seatNumbers;

}

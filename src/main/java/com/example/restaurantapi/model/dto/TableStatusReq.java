package com.example.restaurantapi.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableStatusReq {
    private Long identifierRestaurant;
    private Long identifierTable;
}

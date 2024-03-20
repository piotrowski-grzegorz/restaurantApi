package com.example.restaurantapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public enum TableArrangment {
    REGULAR, HORIZONTAL, VERTICAL;
}

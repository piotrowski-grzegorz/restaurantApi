package com.example.restaurantapi.controller;

import com.example.restaurantapi.dto.NewRestaurantReq;
import com.example.restaurantapi.model.RestaurantModel;
import com.example.restaurantapi.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<RestaurantModel>> getRestaurantById(@PathVariable Long id) {
        Optional<RestaurantModel> restaurant = restaurantService.getConfigurationById(id);
        return ResponseEntity.ok(restaurant);
    }

    @PostMapping
    public ResponseEntity<RestaurantModel> createRestaurant(@Valid @RequestBody NewRestaurantReq request) {
        RestaurantModel restaurant = restaurantService.createRestaurant(request);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }
}

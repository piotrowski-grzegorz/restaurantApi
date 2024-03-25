package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.dto.NewRestaurantReq;
import com.example.restaurantapi.model.dto.RestaurantReqDto;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.service.RestaurantService;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<RestaurantModel> createRestaurant(@Valid @RequestBody NewRestaurantReq request) {
        RestaurantModel restaurant = restaurantService.createRestaurant(request);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @PutMapping ("/update/{id}")
    ResponseEntity<RestaurantModel> updateRestaurantDataById(@PathVariable Long id, @RequestBody RestaurantReqDto req) throws NoRestaurantFoundException {
        RestaurantModel restaurant = restaurantService.updateRestaurant(id, req);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/findByName")
    public ResponseEntity<RestaurantModel> findByName(@RequestParam String name) throws NoRestaurantFoundException {
        RestaurantModel restaurantModel = restaurantService.findByName(name);
        return ResponseEntity.ok(restaurantModel);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        restaurantService.deleteRestaurantByName(id);
        return ResponseEntity.ok().build();
    }

}

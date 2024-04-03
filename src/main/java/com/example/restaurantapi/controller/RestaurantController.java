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

    /**
     * Creates a new restaurant based on provided data.
     *
     * @param request Data required to create the restaurant
     * @return The created restaurant with HTTP status 201
     *
     */
    @PostMapping("/create")
    public ResponseEntity<RestaurantModel> createRestaurant(@Valid @RequestBody NewRestaurantReq request) {
        RestaurantModel restaurant = restaurantService.createRestaurant(request);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    /**
     * Updates an existing restaurant with a new data
     *
     * @param id The ID of the restaurant to update
     * @param req Data required for updating the restaurant
     * @return The update restaurant with HTTP status 200
     * @throws NoRestaurantFoundException if no restaurant is found with the provided id
     *
     */

    @PutMapping ("/update/{id}")
    ResponseEntity<RestaurantModel> updateRestaurantDataById(@PathVariable Long id, @Valid @RequestBody RestaurantReqDto req) throws NoRestaurantFoundException {
        RestaurantModel restaurant = restaurantService.updateRestaurant(id, req);
        return ResponseEntity.ok(restaurant);
    }

    /**
     * Retrives a restaurant by it's name
     *
     * @param name the name of the restaurant to retrieve
     * @return the request restaurant if found, with HTTP status 200
     * @throws NoRestaurantFoundException if no restaurant is found with the provided name
     *
     */
    @GetMapping("/findByName")
    public ResponseEntity<RestaurantModel> findByName(@RequestParam String name) throws NoRestaurantFoundException {
        RestaurantModel restaurantModel = restaurantService.findByName(name);
        return ResponseEntity.ok(restaurantModel);
    }

    /**
     * Retrives a restaurant by its id
     *
     * @param id The id of the restaurant to retrieve
     * @return the request restaurant if found, with HTTP status 200
     * @throws NoRestaurantFoundException if no restaurant is found with the provided id
     *
     */

    @GetMapping("/findById/{id}")
    public ResponseEntity<RestaurantModel> findById(@PathVariable Long id) throws NoRestaurantFoundException {
        RestaurantModel restaurantModel = restaurantService.findById(id);
        return ResponseEntity.ok(restaurantModel);
    }

    /**
     *
     * Delete a restaurant by its ID
     *
     * @param id The id of the configuration to delete
     * @return HTTP status 202 with accepted if the deletion was successful
     * @throws NoRestaurantFoundException if no restaurant is found with the provided id
     *
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws NoRestaurantFoundException {
        restaurantService.deleteRestaurantById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}

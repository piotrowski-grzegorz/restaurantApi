package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.dto.NewMarkReq;
import com.example.restaurantapi.model.entity.RatingModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.service.RatingService;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;
    /**
     * Creates new RatingModel object with provided details
     *
     * @param id the unique identifier of the restaurant to rate
     * @param req The rating details as dto
     * @return The created rating with HTTP status 201
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     */
    @PostMapping("/add/{id}")
    public ResponseEntity<RatingModel> addRating(@PathVariable Long id, @Valid @RequestBody NewMarkReq req) throws NoRestaurantFoundException {
        RatingModel newRating = ratingService.addRating(id, req);
        return new ResponseEntity<>(newRating, HttpStatus.CREATED);
    }

    /**
     * Retrieves all ratings by restaurants unique identifier
     *
     * @param id the unique identifier of the restaurant
     * @return the request ratings if found, with HTTP status 200
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     */
    @GetMapping("get/{id}")
    public ResponseEntity<List<RatingModel>> getAllRatings(@PathVariable Long id) throws NoRestaurantFoundException {
        List<RatingModel> getAllRating = ratingService.findAllRatingByRestaurantId(id);
        return ResponseEntity.ok(getAllRating);
    }

}

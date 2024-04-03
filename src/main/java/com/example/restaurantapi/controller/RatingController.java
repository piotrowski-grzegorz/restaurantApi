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

    @PostMapping("/add/{id}")
    public ResponseEntity<RatingModel> addRating(@PathVariable Long id, @Valid @RequestBody NewMarkReq req) throws NoRestaurantFoundException {
        RatingModel newRating = ratingService.addMark(id, req);
        return new ResponseEntity<>(newRating,HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<RatingModel>> getAllRatings(@PathVariable Long id) {
        List<RatingModel> getAllRating = ratingService.findAllRatingByRestaurantId(id);
        return ResponseEntity.ok(getAllRating);
    }


}

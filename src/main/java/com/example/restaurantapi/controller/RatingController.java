package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.entity.RestaurantModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingController {

    @PostMapping("/addMark/{id}")
    public ResponseEntity<Void> addMark(@PathVariable Long id, @RequestParam Integer mark) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addReview/{id}")
    public ResponseEntity<Void> addReview(@PathVariable Long id, @RequestParam String review) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/marks/{id}")
    public ResponseEntity<Void> gettAllMarks(@PathVariable Long id, @RequestParam String marks) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Void> getAllReviews(@PathVariable Long id, @RequestParam String review) {
        return ResponseEntity.ok().build();
    }


}

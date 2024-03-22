package com.example.restaurantapi.controller;

import com.example.restaurantapi.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.ZonedDateTime;
@RestController
@RequestMapping("/reservationHost")
@RequiredArgsConstructor
public class ReservationHostController {

    private final RestaurantService restaurantService;

    @GetMapping("/getAllReservation")
    public ResponseEntity<Void> getAllReservationInRestaurantByName(@RequestParam String restaurantName) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/confirmReservation")
    public ResponseEntity<Void> confirmReservation(@RequestParam String restaurantName,
                                                   @RequestParam Long TableId,
                                                   @RequestParam boolean isConfirmed) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/rejectReservation")
    public ResponseEntity<Void> rejectReservation(@RequestParam String restaurantName,
                                                  @RequestParam Long TableId,
                                                  @RequestParam boolean isRejected) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateVisiblityForClient")
    public ResponseEntity<Void> updateVisibility(@RequestParam String restaurantName,
                                                 @RequestParam Long TableId,
                                                 @RequestParam boolean isVisible)
    {
        return ResponseEntity.ok().build();
    }



}

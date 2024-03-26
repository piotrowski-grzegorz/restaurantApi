package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.entity.ReservationModel;
import com.example.restaurantapi.service.ReservationClientService;
import com.example.restaurantapi.service.ReservationHostService;
import com.example.restaurantapi.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservationHost")
@RequiredArgsConstructor
public class ReservationHostController {

    private final RestaurantService restaurantService;
    private final ReservationHostService reservationHostService;

    @GetMapping("/getAllReservation/{id}")
    public ResponseEntity<List<ReservationModel>> getAllReservationInRestaurantById(@PathVariable Long id) {
        List<ReservationModel> allReservations = reservationHostService.getAllReservationsByRestaurantId(id);
        return ResponseEntity.ok(allReservations);
    }

    @PutMapping("/confirmReservation/{tel}")
    public ResponseEntity<Void> confirmReservation(@PathVariable String tel, @RequestParam boolean isConfirmed) {
        reservationHostService.confirmReservation(tel, isConfirmed);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/rejectReservation/{tel}")
    public ResponseEntity<Void> rejectReservation(@PathVariable String tel, @RequestParam boolean isRejected) {
        reservationHostService.rejectReservation(tel, isRejected);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateVisibilityForClient")
    public ResponseEntity<Void> updateVisibilityForClient(@PathVariable Long id, @RequestParam boolean isVisible) {
        reservationHostService.updateTableVisibilityForClient(id, isVisible);
        return ResponseEntity.ok().build();
    }



}

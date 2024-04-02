package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.dto.ReservationStatusReq;
import com.example.restaurantapi.model.dto.TableStatusReq;
import com.example.restaurantapi.model.entity.ReservationModel;
import com.example.restaurantapi.service.ReservationClientService;
import com.example.restaurantapi.service.ReservationHostService;
import com.example.restaurantapi.service.RestaurantService;
import com.example.restaurantapi.utils.exception.NoReservationFoundException;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import com.example.restaurantapi.utils.exception.NoTableFoundException;
import jakarta.validation.Valid;
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

    private final ReservationHostService reservationHostService;

    @GetMapping("/getAllReservation/{id}")
    public ResponseEntity<List<ReservationModel>> getAllReservationInRestaurantById(@PathVariable Long id) throws NoReservationFoundException, NoRestaurantFoundException {
        List<ReservationModel> allReservations = reservationHostService.getAllReservationsByRestaurantId(id);
        return ResponseEntity.ok(allReservations);
    }

//    @PutMapping("/confirmReservation/{id}")
//    public ResponseEntity<Void> confirmReservation(@RequestParam String tel,
//                                                   @RequestParam boolean isConfirmed,
//                                                   @PathVariable Long id) throws NoReservationFoundException, NoRestaurantFoundException {
//        reservationHostService.confirmReservation(tel, isConfirmed, id);
//        return ResponseEntity.ok().build();
//    }
@PutMapping("/confirmReservation/")
public ResponseEntity<Void> confirmReservation(@RequestBody ReservationStatusReq req, @RequestParam boolean status) throws NoReservationFoundException, NoRestaurantFoundException {
    reservationHostService.confirmReservation(req, status);
    return ResponseEntity.ok().build();
}

    @PutMapping("/rejectReservation/{id}")
    public ResponseEntity<Void> rejectReservation(@RequestBody ReservationStatusReq req, @RequestParam boolean status) throws NoReservationFoundException, NoRestaurantFoundException {
        reservationHostService.rejectReservation(req, status);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateTableVisibilityForClient/")
    public ResponseEntity<Void> updateTableVisibilityForClient(@RequestBody TableStatusReq req, @RequestParam boolean status) throws NoRestaurantFoundException, NoTableFoundException {
        reservationHostService.updateTableVisibilityForClientByRestaurantId(req, status);
        return ResponseEntity.ok().build();
    }



}

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

    /**
     * Retrieves all reservation by unique identifier of restaurant
     *
     * @param id The unique identifier of restaurant
     * @return the request restaurants if found, with HTTP status 200
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     * @throws NoReservationFoundException If no reservation is found with the provided id
     */

    @GetMapping("/getAllReservationsByRestaurant/{id}")
    public ResponseEntity<List<ReservationModel>> getAllReservationInRestaurantById(@PathVariable Long id)
            throws NoReservationFoundException, NoRestaurantFoundException {
        List<ReservationModel> allReservations = reservationHostService.getAllReservationsByRestaurantId(id);
        return ResponseEntity.ok(allReservations);
    }


    /**
     * Updates confirmation status of reservation to true or false
     *
     * @param req Status of reservation provided by dto
     * @param status Boolean type to update
     * @return the request restaurants if found, with HTTP status 200
     * @throws NoReservationFoundException If no reservation is found with the provided id
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     */
    @PutMapping("/confirmReservation/")
    public ResponseEntity<Void> confirmReservation(@RequestBody ReservationStatusReq req, @RequestParam boolean status)
            throws NoReservationFoundException, NoRestaurantFoundException {
        reservationHostService.confirmReservation(req, status);
        return ResponseEntity.ok().build();
    }

    /**
     * Updates rejection status of reservation to true or false
     *
     * @param req Status of reservation provided by dto
     * @param status Boolean type to update
     * @return the request restaurants if found, with HTTP status 200
     * @throws NoReservationFoundException If no reservation is found with the provided id
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     */
    @PutMapping("/rejectReservation/")
    public ResponseEntity<Void> rejectReservation(@RequestBody ReservationStatusReq req, @RequestParam boolean status) throws NoReservationFoundException, NoRestaurantFoundException {
        reservationHostService.rejectReservation(req, status);
        return ResponseEntity.ok().build();
    }

    /**
     * Updates visibility of table for guest
     *
     * @param req Details provided by dto to update
     * @param status Boolean type to update
     * @return the request restaurants if found, with HTTP status 200
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     * @throws NoTableFoundException If no table is found with the provided id
     */
    @PutMapping("/updateTableVisibilityForClient/")
    public ResponseEntity<Void> updateTableVisibilityForClient(@RequestBody TableStatusReq req, @RequestParam boolean status) throws NoRestaurantFoundException, NoTableFoundException {
        reservationHostService.updateTableVisibilityForClientByRestaurantId(req, status);
        return ResponseEntity.ok().build();
    }


}

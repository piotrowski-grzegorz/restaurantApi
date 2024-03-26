package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.dto.ReservationReq;
import com.example.restaurantapi.model.entity.ReservationModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.model.entity.TableModel;
import com.example.restaurantapi.service.ReservationClientService;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservationClient")
@RequiredArgsConstructor
public class ReservationClientController {

    private final ReservationClientService reservationClientService;



    @GetMapping("/findByCity")
    public ResponseEntity<List<RestaurantModel>> findAllRestaurantsByCity(@RequestParam String city) throws NoRestaurantFoundException {
        List<RestaurantModel> restaurant = reservationClientService.findAllRestaurantsByCity(city);
        return ResponseEntity.ok(restaurant);
    }

    @GetMapping("/findByType")
    public ResponseEntity<List<RestaurantModel>> findByType(@RequestParam String type) throws NoRestaurantFoundException {
        List<RestaurantModel> restaurant = reservationClientService.findAllRestaurantsByType(type);
        return ResponseEntity.ok(restaurant);
    }

    @GetMapping("/findByMarks") // jeżeli za trudne można zostawić na sam koniec
    public ResponseEntity<List<RestaurantModel>> findByMarks(@RequestParam Integer mark) {
        List<RestaurantModel> restaurant = reservationClientService.findAllRestaurantsByMark(mark);
        return ResponseEntity.ok(restaurant);
    }

    @GetMapping("/getTablesByRestaurant")
    public ResponseEntity<List<TableModel>> getTablesByRestaurant(@RequestParam Long id) {
        List<TableModel> tables = reservationClientService.getAllTablesByRestaurantId(id);
        return ResponseEntity.ok(tables);
    }

    @PutMapping("/makeReservation/{id}")
    public ResponseEntity<ReservationReq> makeReservation(@PathVariable Long id, @RequestBody ReservationReq reservation)
    {
        reservationClientService.makeReservation(id, reservation);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    @DeleteMapping("/cancelReservation/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long id)
    {
        reservationClientService.cancelReservation(id);

        return ResponseEntity.ok().build();
    }


}

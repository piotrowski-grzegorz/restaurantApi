package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.service.ReservationClientService;
import com.example.restaurantapi.utils.exception.NoRestaurationFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservationClient")
@RequiredArgsConstructor
public class ReservationClientController {

    private final ReservationClientService reservationClientService;



    @GetMapping("/findByCity") // NIE DZIAŁA zwraca pustą listę
    public ResponseEntity<List<RestaurantModel>> findAllRestaurantsByCity(@RequestParam String city) throws NoRestaurationFoundException {
        List<RestaurantModel> restaurant = reservationClientService.findAllRestaurantsByCity(city);
        return ResponseEntity.ok(restaurant);
    }

    @GetMapping("/findByType")
    public ResponseEntity<RestaurantModel> findByType(@RequestParam String type) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByMarks")
    public ResponseEntity<RestaurantModel> findByMarks(@RequestParam String mark) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getTablesByRestaurant")
    public ResponseEntity<RestaurantModel> getTablesByRestaurant(@RequestParam String mark) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/makeReservation")
    public ResponseEntity<RestaurantModel> makeReservation(@RequestParam String restaurantName
            , @RequestParam Long tableId
            , @RequestParam ZonedDateTime date)
    {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/cancelReservation")
    public ResponseEntity<RestaurantModel> cancelReservation(@RequestParam String restaurantName
            , @RequestParam Long tableId)
    {
        return ResponseEntity.ok().build();
    }


}

package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.dto.ReservationReq;
import com.example.restaurantapi.model.dto.RestaurantReqDto;
import com.example.restaurantapi.model.entity.ReservationModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.model.entity.TableModel;
import com.example.restaurantapi.repository.ReservationClientRepository;
import com.example.restaurantapi.service.ReservationClientService;
import com.example.restaurantapi.utils.exception.NoReservationFoundException;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import com.example.restaurantapi.utils.exception.NoTableFoundException;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservationClient")
@RequiredArgsConstructor
public class ReservationClientController {

    private final ReservationClientService reservationClientService;

    /**
     * Retrieves all restaurants by city name
     *
     * @param city A name of the city
     * @return the request restaurant if found, with HTTP status 200
     * @throws NoRestaurantFoundException If no restaurant is found with the provided city name
     */
    @GetMapping("/findRestaurantByCity")
    public ResponseEntity<List<RestaurantModel>> findAllRestaurantsByCity(@RequestParam String city) throws NoRestaurantFoundException {
        List<RestaurantModel> restaurant = reservationClientService.findAllRestaurantsByCity(city);
        return ResponseEntity.ok(restaurant);
    }

    /**
     * Retrieves all restaurants by the type of cuisine
     *
     *
     * @param type A type of cuisine
     * @return the request restaurant if found, with HTTP status 200
     * @throws NoRestaurantFoundException If no restaurant is found with the provided city name
     */

    @GetMapping("/findRestaurantByType")
    public ResponseEntity<List<RestaurantModel>> findByType(@RequestParam String type) throws NoRestaurantFoundException {
        List<RestaurantModel> restaurant = reservationClientService.findAllRestaurantsByType(type);
        return ResponseEntity.ok(restaurant);
    }

    /**
     * Retrieves all tables found by unique identifier of a restaurant
     *
     * @param id The unique identifier of a restaurant
     * @return the request tables if found, with HTTP status 200
     * @throws NoTableFoundException If no table is available for client
     */

    @GetMapping("/getTablesByRestaurant")
    public ResponseEntity<List<TableModel>> getTablesByRestaurant(@RequestParam Long id) throws NoTableFoundException {
        List<TableModel> tables = reservationClientService.getAllTablesByRestaurantId(id);
        return ResponseEntity.ok(tables);
    }

    /**
     * Create new reservation by guest with provided details
     *
     * @param id The unique identifier of restaurant where we make reservation
     * @param reservation The reservation details as dto
     * @return The created restaurant with HTTP status 201
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     */
    @PutMapping("/makeReservation/{id}")
    public ResponseEntity<ReservationReq> makeReservation(@PathVariable Long id, @Valid @RequestBody ReservationReq reservation)
            throws NoRestaurantFoundException {
        reservationClientService.makeReservation(id, reservation);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    /**
     * Deletes a reservation object by its unique identifier
     *
     * @param id The unique identifier of reservation
     * @return HTTP status 202 with accepted if the deletion was successful
     * @throws NoReservationFoundException If no reservation is found with the provided id
     */

    @DeleteMapping("/cancelReservation/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long id) throws  NoReservationFoundException {
        reservationClientService.cancelReservation(id);

        return ResponseEntity.ok().build();
    }


    /**
     * Retrieves all restaurants rated between min and max values
     *
     * @param min A minimum mark value
     * @param max A maximum mark value
     * @return the request restaurant if found, with HTTP status 200
     * @throws NoRestaurantFoundException If no restaurant is found in the numerical interval
     */
    @GetMapping("/findByAvgMark")
    public ResponseEntity<List<RestaurantReqDto>> getEmployeesBySalary(@RequestParam Integer min, @RequestParam Integer max) throws NoRestaurantFoundException {
        List<RestaurantReqDto> markBetween = reservationClientService.findAverageMarkBetween(min, max);

        return ResponseEntity.ok(markBetween);
    }


}

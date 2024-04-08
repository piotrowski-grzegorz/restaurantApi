package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.dto.NewRestaurantReq;
import com.example.restaurantapi.model.dto.NewTableReq;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.model.entity.TableModel;
import com.example.restaurantapi.service.TableService;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import com.example.restaurantapi.utils.exception.NoTableFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tables")
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;

    /**
     * Creates new TableModel object with the provided details
     *
     * @param id The unique identifier of restaurant where table are created
     * @param request The table details as dto
     * @param status Set status of table visibility for guest
     * @return The created table with HTTP status 201
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     */
    @PostMapping("/create/{id}")
    public ResponseEntity<TableModel> createTable(@PathVariable Long id,
                                                  @Valid @RequestBody NewTableReq request,
                                                  @RequestParam boolean status) throws NoRestaurantFoundException {
        TableModel restaurant = tableService.createTable(id, request, status);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    /**
     * Deletes TableModel object by its unique identifier
     *
     * @param id The unique identifier ot table
     * @return HTTP status 202 with accepted if the deletion was successful
     * @throws NoTableFoundException If no table is found with the provided id
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws NoTableFoundException {
        tableService.deleteTableById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}

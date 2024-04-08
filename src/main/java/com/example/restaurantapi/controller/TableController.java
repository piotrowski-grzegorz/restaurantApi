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

    @PostMapping("/create/{id}")
    public ResponseEntity<TableModel> createTable(@PathVariable Long id,
                                                  @Valid @RequestBody NewTableReq request,
                                                  @RequestParam boolean status) throws NoRestaurantFoundException {
        TableModel restaurant = tableService.createTable(id, request, status);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws NoTableFoundException {
        tableService.deleteTableById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}

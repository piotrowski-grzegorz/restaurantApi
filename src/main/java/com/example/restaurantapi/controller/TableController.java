package com.example.restaurantapi.controller;

import com.example.restaurantapi.service.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table")
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;

    @GetMapping("/mapping")
    public ResponseEntity<Void> showAllTables() {
        return ResponseEntity.status(HttpStatus.FOUND).build();
    }
}

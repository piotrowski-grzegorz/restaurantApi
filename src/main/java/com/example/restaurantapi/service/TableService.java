package com.example.restaurantapi.service;

import com.example.restaurantapi.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
- sprawdzenie czy są dostępne
- pokazanie wszystkiego

 */
@Service
@RequiredArgsConstructor
public class TableService {
    private final TableRepository tableRepository;

    public void getAvailableTablesInRestaurantByName() {};
    public void reserveTable(){};

    //CRUD
    public void createTable(){};
    public void deleteTable(){};
    public void getAvailableTableById(){};


}

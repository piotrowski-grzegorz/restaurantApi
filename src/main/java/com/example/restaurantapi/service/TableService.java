package com.example.restaurantapi.service;

import com.example.restaurantapi.model.TableArrangment;
import com.example.restaurantapi.model.TableModel;
import com.example.restaurantapi.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
/*
- sprawdzenie czy są dostępne
- pokazanie wszystkiego

 */
@Service
@RequiredArgsConstructor
public class TableService {
    private final TableRepository tableRepository;

    public void checkIfAvailableById(Long id) {

    }

    public void showAllTables() {
        tableRepository.findAll();
    }

//    public TableModel changeArrangmentOfTheTableById(Long id, TableArrangment newArr) {
//        TableModel myTable = tableRepository.getTableModelById(id);
//        myTable.setTableArrangment(newArr);
//        return myTable;
//    }
}

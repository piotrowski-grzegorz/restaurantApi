package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.TableModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TableRepository extends JpaRepository<TableModel, Long> {
    public List<TableModel> findAllByRestaurant_Id(Long id);



}

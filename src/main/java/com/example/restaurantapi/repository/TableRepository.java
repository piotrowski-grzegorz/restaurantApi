package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.TableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TableRepository extends JpaRepository<TableModel, Long> {
    public List<TableModel> findAllByRestaurant_Id(Long id);

    Optional<TableModel> findTopByRestaurant_Id(Long id);


}

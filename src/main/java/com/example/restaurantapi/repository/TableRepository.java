package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.TableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TableRepository extends JpaRepository<TableModel, Long> {
    public TableModel getTableModelById(Long id);

}

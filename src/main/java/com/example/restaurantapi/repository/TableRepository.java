package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.TableModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TableRepository extends JpaRepository<TableModel, Long> {
    public TableModel getTableModelById(Long id);

}

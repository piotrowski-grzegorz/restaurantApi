package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.TableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TableRepository extends JpaRepository<TableModel, Long> {
    /**
     * Finds all tables by restaurants ID
     *
     * @param id The unique identifier of the restaurant
     * @return List containing generic type of found restaurant or empty list with no restaurants found
     */
    List<TableModel> findAllByRestaurant_Id(Long id);

    /**
     * Finds one table record by restaurant ID
     *
     * @param id The unique identifier of the restaurant
     * @return List containing generic type of found restaurant or empty list with no restaurants found
     */

    Optional<TableModel> findTopByRestaurant_Id(Long id);


}

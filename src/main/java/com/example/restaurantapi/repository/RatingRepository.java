package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.RatingModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<RatingModel, Long> {

    /**
     * Finds all ratings by restaurant ID
     *
     * @param id The unique identifier of the restaurant
     * @return List containing generic type of found restaurant or empty list with no restaurants found
     */
    List<RatingModel> findAllByRestaurant_Id(Long id);


}

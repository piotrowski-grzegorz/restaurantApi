package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.RatingModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<RatingModel, Long> {

    List<RatingModel> findAllByRestaurant_Id(Long id);



}

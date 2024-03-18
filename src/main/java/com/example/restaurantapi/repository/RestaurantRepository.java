package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantModel, Long> {
}

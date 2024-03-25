package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<RestaurantModel, Long> {
    Optional<RestaurantModel> findByNameIsIgnoreCase(String name);
    void deleteById(Long id);
    Optional<List<RestaurantModel>> findAllByAddress_City(String name);
    List<RestaurantModel> findAllByTypeIgnoreCase(String type);
    List<RestaurantModel> findAllByRating_Mark(Integer mark);


}

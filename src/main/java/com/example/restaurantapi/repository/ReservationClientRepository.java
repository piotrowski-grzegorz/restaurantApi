package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReservationClientRepository extends JpaRepository<RestaurantModel, Long> {

//    @Query(value = "SELECT c from RestaurantModel.address c where c.city = :city")
    public List<RestaurantModel> findRestaurantModelByAddress_City(String city);

    Optional<RestaurantModel> findByAddress_City(String name);
    Optional<List<RestaurantModel>> findAllByAddress_City(String name);

}


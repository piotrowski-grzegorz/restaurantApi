package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationHostRepository extends JpaRepository<ReservationModel, Long> {
    /**
     * Finds all reservations by restaurants ID
     *
     * @param id  id The unique identifier of the restaurant
     * @return List containing generic type of found restaurant or empty list with no restaurants found
     */
    public List<ReservationModel> findAllByRestaurantModelId(Long id);

}

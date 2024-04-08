package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationHostRepository extends JpaRepository<ReservationModel, Long> {

    public List<ReservationModel> findAllByRestaurantModelId(Long id);

}

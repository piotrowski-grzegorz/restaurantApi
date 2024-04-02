package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationClientRepository extends JpaRepository<ReservationModel, Long> {
    Optional<ReservationModel> findByGuestPhoneNumber(String phoneNumber);
    Optional<List<ReservationModel>> findByRestaurantModel_Id(Long id);

















}


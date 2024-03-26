package com.example.restaurantapi.service;

import com.example.restaurantapi.model.entity.ReservationModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.model.entity.TableModel;
import com.example.restaurantapi.repository.ReservationHostRepository;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.repository.TableRepository;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationHostService {
    private final ReservationHostRepository reservationHostRepository;
    private final RestaurantRepository restaurantRepository;
    private final TableRepository tableRepository;

    public List<ReservationModel> getAllReservationsByRestaurantId(Long id) {
        return reservationHostRepository.findAllByRestaurantModelId(id);
    }
    @Transactional
    public void confirmReservation(String phoneNumber, boolean status) {
        reservationHostRepository.updateReservationModelisConfirmedByHost(phoneNumber, status);
    }
    @Transactional
    public void rejectReservation(String phoneNumber, boolean status) {
        reservationHostRepository.updateReservationModelisRejectedByHost(phoneNumber,status);
    }

    @Transactional
    public void updateTableVisibilityForClient(Long id, boolean status) {
        tableRepository.updateTableVisibilityById(id, status);
    }





}

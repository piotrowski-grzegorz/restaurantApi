package com.example.restaurantapi.service;

import com.example.restaurantapi.model.dto.ReservationStatusReq;
import com.example.restaurantapi.model.dto.TableStatusReq;
import com.example.restaurantapi.model.entity.ReservationModel;
import com.example.restaurantapi.model.entity.TableModel;
import com.example.restaurantapi.repository.ReservationClientRepository;
import com.example.restaurantapi.repository.ReservationHostRepository;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.repository.TableRepository;
import com.example.restaurantapi.utils.exception.NoReservationFoundException;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;

import com.example.restaurantapi.utils.exception.NoTableFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ReservationHostService {
    private final ReservationHostRepository reservationHostRepository;
    private final ReservationClientRepository reservationClientRepository;
    private final RestaurantRepository restaurantRepository;
    private final TableRepository tableRepository;



    public List<ReservationModel> getAllReservationsByRestaurantId(Long id) throws NoRestaurantFoundException, NoReservationFoundException {
        List<ReservationModel> list = reservationHostRepository.findAllByRestaurantModelId(id);
        restaurantRepository.findById(id)
                .orElseThrow(() -> new NoRestaurantFoundException("Invalid Restaurant_ID: No restaurant can be found for a restaurant with that ID."));
        if (list.isEmpty()) {
            throw new NoReservationFoundException("Invalid Reservation_ID: No reservations can be found for a restaurant with that ID.");
        }
        return reservationHostRepository.findAllByRestaurantModelId(id);
    }

    @Transactional
    public void confirmReservation(ReservationStatusReq req, boolean status) throws NoReservationFoundException, NoRestaurantFoundException {

        if (restaurantRepository.findById(req.getIdentifierRestaurant()).isEmpty()) {
            throw new NoRestaurantFoundException("Invalid Restaurant_ID: No restaurant can be found with that ID.");

        } else if (reservationClientRepository.findById(req.getIdentifierReservation()).isEmpty()) {
            throw new NoReservationFoundException("Invalid Reservation_ID: No reservation can be found with that ID");
        }

        Optional<ReservationModel> reservationById = reservationClientRepository.findById(req.getIdentifierReservation());
        reservationById.get().setConfirmedByHost(status);
    }

    @Transactional
    public void rejectReservation(ReservationStatusReq req, boolean status) throws NoReservationFoundException, NoRestaurantFoundException {

        boolean isRestaurantEmpty = restaurantRepository.findById(req.getIdentifierRestaurant()).isEmpty();
        boolean isReservationEmpty = reservationClientRepository.findById(req.getIdentifierReservation()).isEmpty();
        if (isRestaurantEmpty) {
            throw new NoRestaurantFoundException("Invalid Restaurant_ID: No restaurant can be found with that ID.");

        } else if (isReservationEmpty) {
            throw new NoReservationFoundException("Invalid Reservation_ID: No reservation can be found with that ID");
        }

        Optional<ReservationModel> reservationById = reservationClientRepository.findById(req.getIdentifierReservation());
        reservationById.get().setRejectedByHost(status);
    }

    @Transactional
    public void updateTableVisibilityForClientByRestaurantId(TableStatusReq req, boolean status) throws NoRestaurantFoundException, NoTableFoundException {
        boolean isRestaurantEmpty = restaurantRepository.findById(req.getIdentifierRestaurant()).isEmpty();
        boolean isTableEmpty = tableRepository.findById(req.getIdentifierTable()).isEmpty();
        boolean isTablePresent = tableRepository.findById(req.getIdentifierTable()).isPresent();
        boolean isTableDoesntBelongToRestaurant = tableRepository.findTopByRestaurant_Id(req.getIdentifierTable()).isEmpty();
        if (isRestaurantEmpty) {
            throw new NoRestaurantFoundException("Invalid Restaurant_ID: No restaurant can be found with that ID.");

        } else if (isTableEmpty) {
            throw new NoTableFoundException("Invalid Table_ID: No table can be found with that ID");
        }

        if (isTableDoesntBelongToRestaurant && isTablePresent) {
            throw new NoTableFoundException("Invalid Restaurant_ID and Table_ID: " +
                    "The restaurant and table with the provided IDs exist, " +
                    "but the restaurant does not have such tables. " +
                    "And the given table is assigned to another restaurant.");
        }

        Optional<TableModel> tableById = tableRepository.findById(req.getIdentifierTable());
        tableById.get().setVisibleForClient(status);
    }
}



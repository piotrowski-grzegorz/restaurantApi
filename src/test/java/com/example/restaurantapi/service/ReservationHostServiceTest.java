package com.example.restaurantapi.service;

import com.example.restaurantapi.model.dto.ReservationStatusReq;
import com.example.restaurantapi.model.entity.ReservationModel;
import com.example.restaurantapi.repository.ReservationClientRepository;
import com.example.restaurantapi.repository.ReservationHostRepository;
import com.example.restaurantapi.utils.exception.NoReservationFoundException;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservationHostServiceTest {
    @Mock
    ReservationHostRepository reservationHostRepository;
    @Mock
    ReservationClientRepository reservationClientRepository;
    @InjectMocks
    ReservationHostService reservationHostService;
    @InjectMocks
    ReservationClientService reservationClientService;



    @Test
    void confirmReservation_ShouldBeTrue() {
        //given
        boolean status = true;
        Long reservationId = 1L;
        ReservationStatusReq req = new ReservationStatusReq();
        req.setIdentifierReservation(reservationId);
        req.setIdentifierRestaurant(reservationId);
        req.setConfirmedByHost(status);
        ReservationModel reservation = new ReservationModel();
        reservation.setConfirmedByHost(req.isConfirmedByHost());

        assertTrue(reservation.isConfirmedByHost(), "should be true");


    }
}
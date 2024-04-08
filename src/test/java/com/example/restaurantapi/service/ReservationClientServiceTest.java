package com.example.restaurantapi.service;

import com.example.restaurantapi.model.dto.ReservationReq;
import com.example.restaurantapi.model.entity.ReservationModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.repository.ReservationClientRepository;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservationClientServiceTest {


    @Mock
    ReservationClientRepository reservationClientRepository;
    @Mock
    RestaurantRepository restaurantRepository;
    @InjectMocks
    ReservationClientService reservationClientService;
    @Test
    void makeNewReservation_ShouldReturnNewReservation() throws NoRestaurantFoundException {
        //given
        ReservationReq req = new ReservationReq();
        RestaurantModel restaurant = new RestaurantModel();
        Long restaurantId = 1L;
        req.setGuestName("Stefan");
        req.setGuestSurname("Kowalski");
        req.setGuestPhoneNumber("555666777");
        req.setComments("Nie przy oknie");
        req.setDate(LocalDateTime.of(2024, 2, 2, 20, 0, 0));
        ReservationModel reservation = new ReservationModel();
        reservation.setGuestName(req.getGuestName());
        reservation.setGuestSurname(req.getGuestSurname());
        reservation.setGuestPhoneNumber(req.getGuestPhoneNumber());
        reservation.setComments(req.getComments());
        reservation.setDate(req.getDate());
        restaurantRepository.save(restaurant);

        when(restaurantRepository.findById(restaurantId)).thenReturn(Optional.of(restaurant));
        when(reservationClientRepository.save(any(ReservationModel.class))).thenReturn(reservation);

        //when

        reservationClientService.makeReservation(1L,req);

        //then

        verify(reservationClientRepository).save(any(ReservationModel.class));
    }
}
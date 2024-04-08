package com.example.restaurantapi.service;

import com.example.restaurantapi.model.dto.ReservationReq;
import com.example.restaurantapi.model.entity.RatingModel;
import com.example.restaurantapi.model.entity.ReservationModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.model.entity.TableModel;
import com.example.restaurantapi.repository.RatingRepository;
import com.example.restaurantapi.repository.ReservationClientRepository;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.repository.TableRepository;
import com.example.restaurantapi.utils.exception.NoReservationFoundException;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import com.example.restaurantapi.utils.exception.NoTableFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationClientService {

    private final ReservationClientRepository reservationClientRepository;
    private final TableRepository tableRepository;
    private final RestaurantRepository restaurantRepository;
    private final RatingRepository ratingRepository;

    public List<RestaurantModel> findAllRestaurantsByCity(String name) throws NoRestaurantFoundException {
        List<RestaurantModel> restaurant = restaurantRepository.findAllByAddressIgnoreCase_City(name);

        if (restaurant.isEmpty()) {
            throw new NoRestaurantFoundException("No restaurants found in the city of " + name);
        }
        return restaurant;

    }


    public List<RestaurantModel> findAllRestaurantsByType(String type) throws NoRestaurantFoundException {
        List<RestaurantModel> restaurant = restaurantRepository.findAllByTypeIgnoreCase(type);
        if (restaurant.isEmpty()) {
            throw new NoRestaurantFoundException("Restaurant specializing in " + type +
                    " cuisine not found.");
        }
        return restaurant;

    }

    public List<RestaurantModel> findAllRestaurantsByMark(Integer mark) {
        return restaurantRepository.findAllByRating_Mark(mark);

    }

    public List<TableModel> getAllTablesByRestaurantId(Long id) throws NoTableFoundException {

        List<TableModel> tablesVisibleForHost = tableRepository.findAllByRestaurant_Id(id);
        List<TableModel> tablesVisibleForClient = isVisibleForClient(tablesVisibleForHost);
        if (tablesVisibleForClient.isEmpty()) {
            throw new NoTableFoundException("No tables available.");
        }
        return tablesVisibleForClient;
    }

    private List<TableModel> isVisibleForClient(List<TableModel> list) {
        list.removeIf(table -> !table.isVisibleForClient());
        return list;
    }

    public void makeReservation(Long id, ReservationReq req) throws NoRestaurantFoundException {
        Optional<RestaurantModel> restaurant = Optional.ofNullable(restaurantRepository.findById(id).orElseThrow(
                () -> new NoRestaurantFoundException
                        ("Invalid RestaurantId: Can't find restaurant with such an ID")));
        ReservationModel newReservation = new ReservationModel();
        newReservation.setGuestName(req.getGuestName());
        newReservation.setGuestSurname(req.getGuestSurname());
        newReservation.setGuestPhoneNumber(req.getGuestPhoneNumber());
        newReservation.setComments(req.getComments());
        newReservation.setRestaurantModel(restaurant.get());
        newReservation.setDate(req.getDate());
        reservationClientRepository.save(newReservation);
    }

    public void cancelReservation(Long id) throws NoReservationFoundException {
        Optional<ReservationModel> reservation = Optional
                .ofNullable(reservationClientRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new NoReservationFoundException
                                        ("Invalid Reservation_ID: Can't find reservation with such an ID")
                        ));
        reservationClientRepository.deleteById(id);

    }
}

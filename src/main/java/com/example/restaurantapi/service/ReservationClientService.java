package com.example.restaurantapi.service;

import com.example.restaurantapi.model.dto.ReservationReq;
import com.example.restaurantapi.model.dto.RestaurantReqDto;
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
import com.example.restaurantapi.utils.mapper.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationClientService {

    private final ReservationClientRepository reservationClientRepository;
    private final TableRepository tableRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    /**
     * Retrieves all restaurants by city name
     *
     * @param name A name of the city
     * @return List of restaurants in the city
     * @throws NoRestaurantFoundException If no restaurant is found with the provided city name
     */
    public List<RestaurantModel> findAllRestaurantsByCity(String name) throws NoRestaurantFoundException {
        List<RestaurantModel> restaurant = restaurantRepository.findAllByAddressIgnoreCase_City(name);

        if (restaurant.isEmpty()) {
            throw new NoRestaurantFoundException("No restaurants found in the city of " + name);
        }
        return restaurant;

    }

    /**
     * Retrieves all restaurants by the type of cuisine
     *
     *
     * @param type A type of cuisine
     * @return List of restaurants found by the type of cuisine
     * @throws NoRestaurantFoundException If no restaurant is found with the provided city name
     */

    public List<RestaurantModel> findAllRestaurantsByType(String type) throws NoRestaurantFoundException {
        List<RestaurantModel> restaurant = restaurantRepository.findAllByTypeIgnoreCase(type);
        if (restaurant.isEmpty()) {
            throw new NoRestaurantFoundException("Restaurant specializing in " + type +
                    " cuisine not found.");
        }
        return restaurant;

    }

    /**
     * Retrieves all restaurants rated between min and max values
     *
     * @param min A minimum mark value
     * @param max A maximum mark value
     * @return List of found restaurants rated from min to max
     * @throws NoRestaurantFoundException If no restaurant is found in the numerical interval
     */

    public List<RestaurantReqDto> findAverageMarkBetween(Integer min, Integer max) throws NoRestaurantFoundException {
        List<RestaurantModel> restaurants = restaurantRepository.findAllByAverageMarkBetween(min, max);
        if(restaurants.isEmpty()) {
            throw new NoRestaurantFoundException("No restaurant found rated between " + min + " and " + max);
        }

        return restaurants.stream()
                .map(ent -> restaurantMapper.toRestaurantReqDto(ent))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all tables found by unique identifier of a restaurant
     *
     * @param id The unique identifier of a restaurant
     * @return List of return restaurant visible to client
     * @throws NoTableFoundException If no table is available for client
     */

    public List<TableModel> getAllTablesByRestaurantId(Long id) throws NoTableFoundException {

        List<TableModel> tablesVisibleForHost = tableRepository.findAllByRestaurant_Id(id);
        List<TableModel> tablesVisibleForClient = setIfTableIsVisibleForClient(tablesVisibleForHost);
        if (tablesVisibleForClient.isEmpty()) {
            throw new NoTableFoundException("No tables available.");
        }
        return tablesVisibleForClient;
    }

    /**
     * Set if table is visible for client
     *
     * @param list List of tables from the restaurant
     * @return List of tables available for clients
     */
    private List<TableModel> setIfTableIsVisibleForClient(List<TableModel> list) {
        list.removeIf(table -> !table.isVisibleForClient());
        return list;
    }

    /**
     * Create new reservation by guest with provided details
     *
     * @param id The unique identifier of restaurant where we make reservation
     * @param req The reservation details as dto
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     */
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

    /**
     * Deletes a reservation object by its unique identifier
     *
     * @param id The unique identifier of reservation
     * @throws NoReservationFoundException If no reservation is found with the provided id
     */
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

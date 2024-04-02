package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<RestaurantModel, Long> {
    Optional<RestaurantModel> findByNameIsIgnoreCase(String name);

    /**
     *
     * Finds a restaurant by address city
     *
     * @param name City name of address
     * @return An optional containing the found restaurant or empty of no restaurant found
     */
    List<RestaurantModel> findAllByAddressIgnoreCase_City(String name);

    /**
     *
     * Finds all restaurants by cuisine's type
     *
     * @param type The cuisine type of the restaurant
     * @return List containing generic type of the found restaurant or empty list with no restaurants found
     */
    List<RestaurantModel> findAllByTypeIgnoreCase(String type);

    /**
     *
     * Finds all restaurants by guest's marks
     *
     * @param mark The average mark given by guests
     * @return List containing generic type of found restaurant or empty list with no restaurants found
     */
    List<RestaurantModel> findAllByRating_Mark(Integer mark);

    /**
     *
     * Deletes a restaurant by unique identifier
     *
     * @param id The unique identifier of restaurant
     */
    void deleteById(Long id);


}

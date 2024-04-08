package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.RatingModel;
import com.example.restaurantapi.model.entity.ReservationModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<RestaurantModel, Long> {
    Optional<RestaurantModel> findByNameIsIgnoreCase(String name);

    /**
     * Finds a restaurant by address city
     *
     * @param name City name of address
     * @return An optional containing the found restaurant or empty of no restaurant found
     */
    List<RestaurantModel> findAllByAddressIgnoreCase_City(String name);

    /**
     * Finds all restaurants by cuisine's type
     *
     * @param type The cuisine type of the restaurant
     * @return List containing generic type of the found restaurant or empty list with no restaurants found
     */
    List<RestaurantModel> findAllByTypeIgnoreCase(String type);

    /**
     * Finds all restaurants by guest's marks
     *
     * @param mark The average mark given by guests
     * @return List containing generic type of found restaurant or empty list with no restaurants found
     */
    List<RestaurantModel> findAllByRating_Mark(Integer mark);

    /**
     * Finds all restaurant with addresses
     *
     * @return List containing generic type of found restaurant or empty list with no restaurant found
     */
    @Query(value = "select r from RestaurantModel r join fetch r.address")
    List<RestaurantModel> findAll();

    /**
     * Finds all restaurants with marks between min and max
     *
     * @param min The minimum value of mark from 1 to 5
     * @param max the maximum value of mark from 1 to 5
     * @return List containing generic type of found restaurant or empty list with no restaurants found
     */
    @Query("select e from RestaurantModel e where e.averageMark between :min and :max")
    List<RestaurantModel> findAllByAverageMarkBetween(@Param("min") Integer min, @Param("max") Integer max);


}

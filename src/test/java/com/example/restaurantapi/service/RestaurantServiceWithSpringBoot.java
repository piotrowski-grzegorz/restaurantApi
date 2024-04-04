package com.example.restaurantapi.service;

import com.example.restaurantapi.model.AddressModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class RestaurantServiceWithSpringBoot {

    @MockBean
    RestaurantRepository restaurantRepository;
    @Autowired
    RestaurantService restaurantService;

    @Test
    void findRestaurantByName() throws NoRestaurantFoundException {
        //given
        String restaurantName = "DA LUCA";

        var restaurant = new RestaurantModel();
        restaurant.setName(restaurantName);
        restaurant.setAddress(new AddressModel(
                "Wołoska",
                "3",
                "5",
                "00-001",
                "Warszawa", "Polska"));



        when(restaurantRepository.findByNameIsIgnoreCase(Mockito.anyString()))
                .thenReturn(Optional.of(restaurant));

        //when

        RestaurantModel restaurantByName = restaurantService.findByName(restaurantName);
        //then
        Assertions.assertEquals(restaurantName, restaurantByName.getName());
    }



}

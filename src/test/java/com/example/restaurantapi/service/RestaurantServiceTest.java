package com.example.restaurantapi.service;

import com.example.restaurantapi.model.AddressModel;
import com.example.restaurantapi.model.dto.NewRestaurantReq;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RestaurantServiceTest {
    private RestaurantService restaurantService;
    private RestaurantRepository restaurantRepository;

    @BeforeEach
    void setUp() {
        restaurantRepository = Mockito.mock(RestaurantRepository.class);
        RestaurantService restaurantService = new RestaurantService(restaurantRepository);
        restaurantRepository = new InMemoryRestaurantRepository();
        RestaurantModel restaurantModel = new RestaurantModel();

    }


    @Test
    void createRestaurant() {
        //given
//        NewRestaurantReq newRestaurant = new NewRestaurantReq();
//        AddressModel newAddress = new AddressModel();
//        newAddress.setStreetName("Sienkiewicza");
//        newAddress.setBuildingNumber("4");
//        newAddress.setApartmentNumber("12");
//        newAddress.setCity("Warszawa");
//        newAddress.setPostalCode("11-111");
//        newAddress.setCountry("Polska");
//        newRestaurant.setName("Pierogarnia");
//        newRestaurant.setType("polska");
//        newRestaurant.setOpenHour("9:00");
//        newRestaurant.setCloseHour("19:00");
//        newRestaurant.setAddress(newAddress);
//        //when
//        NewRestaurantReq createdRestaurant = restaurantService.createRestaurant(newRestaurant);
//        //then
//        assertEquals(newRestaurant, createdRestaurant);
    }

    @Test
    void updateRestaurant() {
    }



    @Test
    void findByName() throws NoRestaurantFoundException {
        //given
        String restaurantName = "DA LUCA";
        var restaurant = new RestaurantModel();
        restaurant.setName(restaurantName);
        restaurant.setAddress(new AddressModel("Mickiewicza",
                "2",
                "3",
                "41-000",
                "Warszawa",
                "Polska"));
        when(restaurantRepository.findByNameIsIgnoreCase(restaurantName))
                .thenReturn(Optional.of(restaurant));

        //when

        RestaurantModel restaurantModelByName = restaurantService.findByName(restaurantName);
        //then
        assertEquals(restaurantName, restaurantModelByName.getName());
    }

    @Test
    void findByAdressId() {
    }

    @Test
    void deleteRestaurantById() {
    }
}
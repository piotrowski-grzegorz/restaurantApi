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
    private RestaurantRepository restaurantRepository;
    private RestaurantService restaurantService;
    @BeforeEach
    void setUp() {
        restaurantRepository = Mockito.mock(RestaurantRepository.class);
//        restaurantService = Mockito.mock(RestaurantService.class);
//        restaurantRepository = new InMemoryRestaurantRepository();
        restaurantService = new RestaurantService(restaurantRepository);

    }


    @Test
    void createRestaurant() {
//        //given
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
//        when(restaurantRepository.)
//        //when
//        RestaurantModel createdRestaurant = restaurantService.createRestaurant(newRestaurant);
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
        restaurant.setAddress(new AddressModel(
                "Wołoska",
                "3",
                "5",
                "00-001",
                "Warszawa", "Polska"));
        when(restaurantRepository.findByNameIsIgnoreCase(Mockito.anyString()))
                .thenReturn(Optional.of(restaurant));

        //when

        RestaurantModel restaurantModelByName = restaurantService.findByName(restaurantName);
        //then
        assertEquals(restaurantName, restaurantModelByName.getName());
        assertEquals("Polska", restaurantModelByName.getAddress().getCountry());
    }

    @Test
    void findByAdressId() {
    }

    @Test
    void deleteRestaurantById() {
    }
}
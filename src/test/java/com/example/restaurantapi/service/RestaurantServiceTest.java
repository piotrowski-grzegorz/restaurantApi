package com.example.restaurantapi.service;

import com.example.restaurantapi.model.AddressModel;
import com.example.restaurantapi.model.dto.NewRestaurantReq;
import com.example.restaurantapi.model.dto.RestaurantReqDto;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import com.example.restaurantapi.utils.mapper.RestaurantMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest {
    @Mock
    private RestaurantRepository restaurantRepository;
    @InjectMocks
    private RestaurantMapper restaurantMapper;
    @InjectMocks
    private RestaurantService restaurantService;

    @Test
    void createNewRestaurant_ShouldReturnNewRestaurant() {


        //given
        NewRestaurantReq newRestaurant = new NewRestaurantReq();
        AddressModel newAddress = new AddressModel();
        newAddress.setStreetName("Sienkiewicza");
        newAddress.setBuildingNumber("4");
        newAddress.setApartmentNumber("12");
        newAddress.setCity("Warszawa");
        newAddress.setPostalCode("11-111");
        newAddress.setCountry("Polska");
        newRestaurant.setName("Pierogarnia");
        newRestaurant.setType("polska");
        newRestaurant.setOpenHour("9:00");
        newRestaurant.setCloseHour("19:00");
        newRestaurant.setAddress(newAddress);
        RestaurantModel restaurantEntity = restaurantMapper.fromNewRestaurantReqToEntity(newRestaurant);

        when(restaurantRepository.save(any(RestaurantModel.class))).thenReturn(restaurantEntity);
        //when
        RestaurantModel createdRestaurant = restaurantService.createRestaurant(newRestaurant);

        //then
        assertEquals(restaurantEntity, createdRestaurant);
        verify(restaurantRepository).save(any(RestaurantModel.class));

    }
    @Test
    void updateRestaurantDataById_ShouldReturnUpdatedExistingRestaurant() throws NoRestaurantFoundException {
        //given
        Long idRestaurant = 1L;
        RestaurantModel restaurantModel = new RestaurantModel();
        restaurantModel.setName("Nowa nazwa");
        restaurantModel.setType("Nowa");
        restaurantModel.setOpenHour("0:00");
        restaurantModel.setCloseHour("2:00");


        when(restaurantRepository.findById(idRestaurant)).thenReturn(Optional.of(restaurantModel));
        when(restaurantRepository.save(any(RestaurantModel.class))).thenReturn(restaurantModel);
        RestaurantReqDto dto = restaurantMapper.toRestaurantReqDto(restaurantModel);


        //when
        RestaurantModel result = restaurantService.updateRestaurant(idRestaurant, dto);

        //then

        assertNotNull(restaurantModel);
        assertEquals(result, restaurantModel);
    }

    @Test
    void updateRestaurant_ShouldThrowExceptionWhenNotFound() {
        //given
        Long idRestaurant = 1L;
        RestaurantModel restaurantModel = new RestaurantModel();
        restaurantModel.setName("Nowa nazwa");
        restaurantModel.setType("Nowa");
        restaurantModel.setOpenHour("0:00");
        restaurantModel.setCloseHour("2:00");
        restaurantRepository.save(restaurantModel);
        RestaurantReqDto dto = restaurantMapper.toRestaurantReqDto(restaurantModel);

        when(restaurantRepository.findById(idRestaurant)).thenReturn(Optional.empty());


        assertThrows(NoRestaurantFoundException.class, () -> restaurantService.updateRestaurant(idRestaurant,
                dto));
    }

    @Test
    void deleteRestaurant_ShouldDeleteWhenFound() throws NoRestaurantFoundException {
        //give
        Long id = 1L;

        when(restaurantRepository.existsById(id)).thenReturn(true);
        //when
        restaurantService.deleteRestaurantById(id);

        //then
        verify(restaurantRepository).deleteById(id);
    }

    @Test
    void findByName_ShouldReturnExistingRestaurant() throws NoRestaurantFoundException {
        //given
        String restaurantName = "PIEROGARNIA";

        //when
        RestaurantModel existingRestaurant = new RestaurantModel();
        existingRestaurant.setName(restaurantName);
        when(restaurantRepository.findByNameIsIgnoreCase(restaurantName))
                .thenReturn(Optional.of(existingRestaurant));
        //then
        RestaurantModel resultRestaurant = restaurantService.findByName(restaurantName);
        assertEquals(restaurantName, resultRestaurant.getName());
    }
}

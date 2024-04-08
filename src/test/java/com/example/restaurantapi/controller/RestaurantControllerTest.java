package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.dto.NewRestaurantReq;
import com.example.restaurantapi.model.dto.RestaurantReqDto;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.service.RestaurantService;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(controllers = RestaurantController.class)
//@WithMockUser(username = "Gordon", password = "pass", roles = "GUEST")
//@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class RestaurantControllerTest {
    @Mock
    private RestaurantService restaurantService;
    @InjectMocks
    private RestaurantController restaurantController;

    @Test
    void createRestaurant_ShouldReturnCreatedRestaurant() {

        //given
        NewRestaurantReq requestDto = new NewRestaurantReq();
        requestDto.setName("JARSKA");
        requestDto.setType("polska");
        requestDto.setOpenHour("7:00");
        requestDto.setCloseHour("15:00");

        RestaurantModel createdRestaurant = new RestaurantModel();
        createdRestaurant.setName(requestDto.getName());
        createdRestaurant.setType(requestDto.getType());
        createdRestaurant.setOpenHour(requestDto.getOpenHour());
        createdRestaurant.setCloseHour(requestDto.getCloseHour());

        when(restaurantService.createRestaurant(requestDto))
                .thenReturn(createdRestaurant);

        //when
        ResponseEntity<RestaurantModel> response = restaurantController.createRestaurant(requestDto);

        //then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdRestaurant, response.getBody());
    }

    @Test
    void getRestaurantByName_ShouldReturnRequestedRestaurant() throws NoRestaurantFoundException {
        String nameRestaurant = "Polska";
        RestaurantModel restaurantModelExample = new RestaurantModel();
        restaurantModelExample.setName(nameRestaurant);

        when(restaurantService.findByName(nameRestaurant)).thenReturn(restaurantModelExample);

        ResponseEntity<RestaurantModel> response = restaurantController.findByName(nameRestaurant);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(nameRestaurant, response.getBody().getName());

    }

    @Test
    void updateRestaurant_ShouldReturnUpdatedRestaurant() throws NoRestaurantFoundException {
        //given
        Long id = 1L;
        RestaurantReqDto requestDto = new RestaurantReqDto();
        requestDto.setName("JARSKA");
        requestDto.setType("polska");
        requestDto.setOpenHour("7:00");
        requestDto.setCloseHour("15:00");

        RestaurantModel updatedRestaurant = new RestaurantModel();
        updatedRestaurant.setName(requestDto.getName());
        updatedRestaurant.setType(requestDto.getType());
        updatedRestaurant.setOpenHour(requestDto.getOpenHour());
        updatedRestaurant.setCloseHour(requestDto.getCloseHour());

        when(restaurantService.updateRestaurant(id, requestDto))
                .thenReturn(updatedRestaurant);

        ResponseEntity<RestaurantModel> response = restaurantController.updateRestaurantDataById(id, requestDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedRestaurant,response.getBody());
    }

    @Test
    void deleteRestaurant_ShouldReturnNoContent() throws NoRestaurantFoundException {
        Long id = 1L;

        ResponseEntity<Void> response = restaurantController.deleteById(id);

            assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        verify(restaurantService).deleteRestaurantById(id);
    }
}
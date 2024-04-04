package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.service.RestaurantService;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = RestaurantController.class)
@WithMockUser(username = "Gordon", password = "pass", roles = "GUEST")
//@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class RestaurantControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    RestaurantService restaurantService;

    @Test
    void findByName() throws Exception {
        //given
        String restaurantName = "KOLEJORZ";
        var restaurant = new RestaurantModel();
        restaurant.setName(restaurantName);

        Mockito.when(restaurantService.findByName(restaurantName)).thenReturn(restaurant);

        //when //then
        mockMvc.perform(get("/restaurant/findByName")
                .param("name", restaurantName))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(restaurantName));


    }
}
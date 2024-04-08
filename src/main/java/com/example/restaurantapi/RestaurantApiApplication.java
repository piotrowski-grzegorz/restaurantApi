package com.example.restaurantapi;

import com.example.restaurantapi.model.entity.RatingModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.service.RatingService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestaurantApiApplication {

    public static void main(String[] args)
    {SpringApplication.run(RestaurantApiApplication.class, args);}



}

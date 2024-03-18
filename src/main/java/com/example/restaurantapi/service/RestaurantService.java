package com.example.restaurantapi.service;

import com.example.restaurantapi.dto.NewRestaurantReq;
import com.example.restaurantapi.model.RestaurantModel;
import com.example.restaurantapi.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Optional<RestaurantModel> getConfigurationById(Long id) {
        Optional<RestaurantModel> optRestaurant = restaurantRepository.findById(id);
        return optRestaurant;
    }
    public RestaurantModel createRestaurant(NewRestaurantReq req) {
        RestaurantModel newRestaurant = new RestaurantModel();
        newRestaurant.setName(req.getName());
        newRestaurant.setType(req.getType());
        newRestaurant.setOpenHour(req.getOpenHour());
        newRestaurant.setCloseHour(req.getCloseHour());
        return newRestaurant;
    }
//    public RestaurantModel createRestaurant(String name, String type, String openHour, String closeHour) {
//        RestaurantModel newRestaurant = new RestaurantModel();
//        newRestaurant.setName(name);
//        newRestaurant.setType(type);
//        newRestaurant.setOpenHour(openHour);
//        newRestaurant.setCloseHour(closeHour);
//        return restaurantRepository.save(newRestaurant);
//    }


}

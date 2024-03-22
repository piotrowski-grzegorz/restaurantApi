package com.example.restaurantapi.service;

import com.example.restaurantapi.model.dto.NewRestaurantReq;
import com.example.restaurantapi.model.dto.RestaurantReqDto;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.utils.exception.NoRestaurationFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantModel createRestaurant(NewRestaurantReq req) {
        RestaurantModel newRestaurant = new RestaurantModel();
        newRestaurant.setName(req.getName());
        newRestaurant.setType(req.getType());
        newRestaurant.setOpenHour(req.getOpenHour());
        newRestaurant.setCloseHour(req.getCloseHour());
        newRestaurant.setAddress(req.getAddress());
        return restaurantRepository.save(newRestaurant);
    }

    public RestaurantModel updateRestaurant(Long id, RestaurantReqDto req) throws NoRestaurationFoundException {
        RestaurantModel restaurant = restaurantRepository.findById(id)
                .orElseThrow( () -> new NoRestaurationFoundException("Not found nein"));
        restaurant.setName(req.getName());
        restaurant.setType(req.getType());
        restaurant.setOpenHour(req.getOpenHour());
        restaurant.setCloseHour(req.getCloseHour());
        return restaurantRepository.save(restaurant);
    }

    public RestaurantModel findByName(String restaurantName) throws NoRestaurationFoundException {
        Optional<RestaurantModel> optRestaurant = restaurantRepository.findByNameIsIgnoreCase(restaurantName);

        if(optRestaurant.isPresent()) {
            RestaurantModel restuarant = optRestaurant.get();
            return restuarant;
        }
        throw new NoRestaurationFoundException("Not found Restaurant , Hello from findByName");
    }

    public void deleteRestaurantByName(Long id)
    {
        restaurantRepository.deleteById(id);
    }

    public void findRestaurantByCity(){};
    public void findRestaurantByCuisineType(){};
    public void findRestaurantByMarks(){};
    




}

package com.example.restaurantapi.service;

import com.example.restaurantapi.model.AddressModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.repository.ReservationClientRepository;
import com.example.restaurantapi.utils.exception.NoRestaurationFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationClientService {

    private final ReservationClientRepository reservationClientRepository;

//    public List<RestaurantModel> findAllRestaurantsByCity(String name) {
//        List<RestaurantModel> list = reservationClientRepository.findRestaurantModelByAddress_City(name);
//        reservationClientRepository.
//        return list.stream().filter(x-> x.getAddress().getCity().equals(name)).toList();
//    }

    public List<RestaurantModel> findAllRestaurantsByCity(String name) throws NoRestaurationFoundException {
        Optional<List<RestaurantModel>> optRestaurant = reservationClientRepository.findAllByAddress_City(name);
        if(optRestaurant.isPresent()) {
            List<RestaurantModel> restaurantModel = optRestaurant.get();
            return restaurantModel;
        }
        throw new NoRestaurationFoundException("Not found Restaurant from City " + name);
//        return reservationClientRepository.saveAll(list);

    }
}

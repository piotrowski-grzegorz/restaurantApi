package com.example.restaurantapi.service;

import com.example.restaurantapi.model.dto.NewRestaurantReq;
import com.example.restaurantapi.model.dto.RestaurantReqDto;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import com.example.restaurantapi.utils.mapper.RestaurantMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    /**
     *
     * Creates new RestaurantModel object with the provided details.
     *
     * @param req The restaurant details as dto
     * @return A new RestaurantModel object with provided details
     */

    public RestaurantModel createRestaurant(NewRestaurantReq req) {
        RestaurantModel newRestaurant = new RestaurantModel();
        newRestaurant.setName(req.getName());
        newRestaurant.setType(req.getType());
        newRestaurant.setOpenHour(req.getOpenHour());
        newRestaurant.setCloseHour(req.getCloseHour());
        newRestaurant.setAddress(req.getAddress());
        return restaurantRepository.save(newRestaurant);
    }

    /**
     *
     * Updates an existing restaurant with new details
     *
     * @param id the unique identifier of the restaurant to update
     * @param req The new restaurant details as dto
     * @return The update RestaurantModel object
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     */

    public RestaurantModel updateRestaurant(Long id, RestaurantReqDto req) throws NoRestaurantFoundException {
        RestaurantModel restaurant = restaurantRepository.findById(id)
                .orElseThrow( () -> new NoRestaurantFoundException("Can't update restaurant data because there is no restaurant with such an ID"));
        restaurant.setName(req.getName());
        restaurant.setType(req.getType());
        restaurant.setOpenHour(req.getOpenHour());
        restaurant.setCloseHour(req.getCloseHour());
        return restaurantRepository.save(restaurant);
    }

    /**
     *
     * Retrives a restaurant by its unique identifier
     *
     * @param restaurantName
     * @return
     * @throws NoRestaurantFoundException
     */
    public RestaurantModel findByName(String restaurantName) throws NoRestaurantFoundException {
        Optional<RestaurantModel> optRestaurant = Optional.ofNullable(restaurantRepository.findByNameIsIgnoreCase(restaurantName)
                .orElseThrow(() -> new NoRestaurantFoundException("Invalid Restaurant_name: Can't find restaurant's data because there is no restaurant with such a name")));

//        if(optRestaurant.isPresent()) {
//
//        }
//        throw new NoRestaurantFoundException("Can't find restaurant's data because there is no restaurant with such an ID");
        return optRestaurant.get();
    }

    /**
     *
     * Retrives a restaurant by its unique identifier
     *
     * @param id
     * @return
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     */

    public RestaurantModel findById(Long id) throws NoRestaurantFoundException {
        Optional<RestaurantModel> optRestaurant = restaurantRepository.findById(id);
        if( optRestaurant.isPresent()) {
            return optRestaurant.get();
        }
        throw new NoRestaurantFoundException("Invalid Restaurant_ID: Can't find restaurant's address because there is no address with such an ID");
    }

    /**
     *
     * Deletes a restaurant by its unique identifier
     *
     * @param id The unique
     *
     * @throws NoRestaurantFoundException if no restaurant is found with the provided id
     */
    public void deleteRestaurantById(Long id) throws NoRestaurantFoundException {
        Optional<RestaurantModel> optRestaurant = restaurantRepository.findById(id);
        if(!restaurantRepository.existsById(id)) {
            throw new NoRestaurantFoundException("Can't delete restaurant " +
                    "object because there is no restaurant with such an ID");
        } restaurantRepository.deleteById(id);
    }

    public List<RestaurantReqDto> findAverageMarkBetween(Integer min, Integer max) {
        List<RestaurantModel> restaurants = restaurantRepository.findAllByAverageMarkBetween(min, max);

        return restaurants.stream()
                .map(ent -> restaurantMapper.toRestaurantReqDto(ent))
                .collect(Collectors.toList());
    }

}

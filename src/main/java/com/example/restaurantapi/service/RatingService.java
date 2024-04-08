package com.example.restaurantapi.service;

import com.example.restaurantapi.model.dto.NewMarkReq;
import com.example.restaurantapi.model.entity.RatingModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.repository.RatingRepository;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class RatingService {

    private final RatingRepository ratingRepository;
    private final RestaurantRepository restaurantRepository;

    /**
     * Creates new RatingModel object with provided details
     *
     * @param restaurantId the unique identifier of the restaurant to rate
     * @param req The rating details as dto
     * @return A new RatingModel object with provided details
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     */

    public RatingModel addRating(Long restaurantId, NewMarkReq req) throws NoRestaurantFoundException {
        Optional<RestaurantModel> optRestaurant = restaurantRepository.findById(restaurantId);
        if (optRestaurant.isEmpty()) {
            throw new NoRestaurantFoundException("No restaurant found with such ID");
        }

        RatingModel ratingModel = new RatingModel();
        ratingModel.setName(req.getName());
        ratingModel.setSurname(req.getSurname());
        ratingModel.setMark(req.getMark());
        ratingModel.setReview(req.getReview());
        ratingModel.setRestaurant(optRestaurant.get());

        optRestaurant.get().getRating().add(ratingModel);
        calculateAverageMark(optRestaurant);
        return ratingRepository.save(ratingModel);
    }

    /**
     * Retrieves all ratings by restaurants unique identifier
     *
     * @param id the unique identifier of the restaurant
     * @return List of ratings for unique restaurant
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     */

    public List<RatingModel> findAllRatingByRestaurantId(Long id) throws NoRestaurantFoundException {
        Optional<RestaurantModel> optRestaurant = restaurantRepository.findById(id);
        if (optRestaurant.isEmpty()) {
            throw new NoRestaurantFoundException("No restaurant found with such ID");
        }

        return ratingRepository.findAllByRestaurant_Id(id);
    }

    /**
     * Calculate average Mark of the restaurant based on all received marks
     *
     * @param optRestaurant Optional of RestaurantModel object
     */

    private void calculateAverageMark(Optional<RestaurantModel> optRestaurant) {
        double average = optRestaurant.get().getRating().stream()
                .mapToInt(RatingModel::getMark)
                .average()
                .orElse(0.0);
        optRestaurant.get().setAverageMark(average);
    }
}


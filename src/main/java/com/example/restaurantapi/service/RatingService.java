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

    public RatingModel addRating(Long restaurantId, NewMarkReq req) throws NoRestaurantFoundException {
        Optional<RestaurantModel> optRestaurant = restaurantRepository.findById(restaurantId);
        if (optRestaurant.isEmpty()) {
            throw  new NoRestaurantFoundException("No restaurant found with such ID");
        }

        RatingModel ratingModel = new RatingModel();
        ratingModel.setName(req.getName());
        ratingModel.setSurname(req.getSurname());
        ratingModel.setMark(req.getMark());
        ratingModel.setReview(req.getReview());
        ratingModel.setRestaurant(optRestaurant.get());

        optRestaurant.get().getRating().add(ratingModel);

        double average = optRestaurant.get().getRating().stream()
                .mapToInt(RatingModel::getMark)
                .average()
                .orElse(0.0);
        optRestaurant.get().setAverageMark(average);


        return ratingRepository.save(ratingModel);
    }

    public List<RatingModel> findAllRatingByRestaurantId(Long id) {
        return ratingRepository.findAllByRestaurant_Id(id);
    }
}

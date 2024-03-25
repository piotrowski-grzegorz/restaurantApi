//package com.example.restaurantapi.service;
//
//import com.example.restaurantapi.model.entity.PhotoModel;
//import com.example.restaurantapi.model.entity.RestaurantModel;
//import com.example.restaurantapi.repository.PhotoRepository;
//import com.example.restaurantapi.repository.RestaurantRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class PhotoService {
//    private final PhotoRepository photoRepository;
//    private final RestaurantRepository restaurantRepository;
//
//    public PhotoModel addPhotoForRestaurant(Long restaurantId, byte[] photoData) {
//
//        RestaurantModel restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("Restaurant not found"));
//
//        PhotoModel photo = new PhotoModel();
//        photo.setData(photoData);
//        PhotoModel savedPhoto = photoRepository.save(photo);
//        restaurant.getPhotos().add(savedPhoto);
//        restaurantRepository.save(restaurant);
//
//        return savedPhoto;
//    }
//
//}

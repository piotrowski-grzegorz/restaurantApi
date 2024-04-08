package com.example.restaurantapi.utils.mapper;
import com.example.restaurantapi.model.dto.NewRestaurantReq;
import com.example.restaurantapi.model.dto.RestaurantReqDto;
import com.example.restaurantapi.model.entity.RestaurantModel;
import org.springframework.stereotype.Component;
@Component
public class RestaurantMapper {

    public NewRestaurantReq toNewRestaurantReqDto(RestaurantModel entity) {
        NewRestaurantReq dto = new NewRestaurantReq();
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setOpenHour(entity.getOpenHour());
        dto.setCloseHour(entity.getCloseHour());
        return dto;
    }
    public RestaurantModel fromNewRestaurantReqToEntity(NewRestaurantReq dto) {
        RestaurantModel entity = new RestaurantModel();
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setOpenHour(dto.getOpenHour());
        entity.setCloseHour(dto.getCloseHour());
        return entity;
    }

    public RestaurantReqDto toRestaurantReqDto(RestaurantModel entity) {
        RestaurantReqDto dto = new RestaurantReqDto();
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setOpenHour(entity.getOpenHour());
        dto.setCloseHour(entity.getCloseHour());
        return dto;
    }
    public RestaurantModel fromRestaurantReqToEntity(RestaurantReqDto dto) {
        RestaurantModel entity = new RestaurantModel();
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setOpenHour(dto.getOpenHour());
        entity.setCloseHour(dto.getCloseHour());
        return entity;
    }

}


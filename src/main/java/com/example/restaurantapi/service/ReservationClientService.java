package com.example.restaurantapi.service;

import com.example.restaurantapi.model.dto.ReservationReq;
import com.example.restaurantapi.model.entity.ReservationModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.model.entity.TableModel;
import com.example.restaurantapi.repository.ReservationClientRepository;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.repository.TableRepository;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationClientService {

    private final ReservationClientRepository reservationClientRepository;
    private final TableRepository tableRepository;
    private final RestaurantRepository restaurantRepository;

    public List<RestaurantModel> findAllRestaurantsByCity(String name) throws NoRestaurantFoundException {
        Optional<List<RestaurantModel>> optRestaurant = restaurantRepository.findAllByAddress_City(name);
        if (optRestaurant.isPresent()) {
            List<RestaurantModel> restaurantModel = optRestaurant.get();
            return restaurantModel;
        }
        throw new NoRestaurantFoundException("Not found Restaurant from City " + name);

    }

    public List<RestaurantModel> findAllRestaurantsByType(String type) throws NoRestaurantFoundException {
        RestaurantModel restaurantModel = new RestaurantModel();


        List<RestaurantModel> optRestaurant = restaurantRepository
                .findAllByTypeIgnoreCase(type);
//        optRestaurant.orElseThrow(() -> new NoRestaurationFoundException("NOT FOUND"));
//        if (optRestaurant.isPresent()) {
//            List<RestaurantModel> restaurantModel = optRestaurant.get();
//            return restaurantModel;
//        }
//        List<RestaurantModel> restaurantModel = optRestaurant.get();
        if (optRestaurant.isEmpty()) {
            new NoRestaurantFoundException("NO SUCH TYPE HAVE BEEN FOUND");
        }
        return optRestaurant;
//        throw new NoRestaurationFoundException("No such type found " + type);
    }

    /*
    MUSZĘ WPROWADZIĆ NAJPIERW ŚREDNIĄ W TABELI RESTAURANT - > ŚREDNIA = AVG_MARK
    POTEM MUSZĘ WYWOŁAĆ W METODZIE GETALL AVGMARK BETWEEN 4,00 A 4,99
     */
    public List<RestaurantModel> findAllRestaurantsByMark(Integer mark) {
        RestaurantModel restaurantModel = new RestaurantModel();
        return restaurantRepository.findAllByRating_Mark(mark);
//        List<RestaurantModel> l =
//        l.stream().filter(x -> x.getRating().)
//        return
    }

    public List<TableModel> getAllTablesByRestaurantId(Long id) {
        List<TableModel> list = tableRepository.findAllByRestaurant_Id(id);
        return isVisibleForClient(list);
    }

    private List<TableModel> isVisibleForClient(List<TableModel> list) {
        list.removeIf(table -> !table.isVisibleForClient());
        return list;
    }

    public ReservationModel makeReservation(Long id, ReservationReq req){
        Optional<RestaurantModel> restaurant = restaurantRepository.findById(id);
        ReservationModel newReservation = new ReservationModel();
        newReservation.setGuestName(req.getGuestName());
        newReservation.setGuestSurname(req.getGuestSurname());
        newReservation.setGuestPhoneNumber(req.getGuestPhoneNumber());
        newReservation.setComments(req.getComments());
        newReservation.setRestaurantModel(restaurant.get());
        return reservationClientRepository.save(newReservation);
    }

    public void cancelReservation(Long id) {
        reservationClientRepository.deleteById(id);

    }




}

//    public Integer getAvgMark(String city) {
//
//        Optional<List<RestaurantModel>> r = reservationClientRepository.findAllByAddress_City(city);
//        r.filter(x -> x.)
//    }
//}
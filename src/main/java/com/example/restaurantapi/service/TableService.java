package com.example.restaurantapi.service;

import com.example.restaurantapi.model.dto.NewRestaurantReq;
import com.example.restaurantapi.model.dto.NewTableReq;
import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.model.entity.TableModel;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.repository.TableRepository;
import com.example.restaurantapi.utils.exception.NoRestaurantFoundException;
import com.example.restaurantapi.utils.exception.NoTableFoundException;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableService {

    private final TableRepository tableRepository;
    private final RestaurantRepository restaurantRepository;

    /**
     * Creates new TableModel object with the provided details
     *
     * @param restaurantId The unique identifier of restaurant where table are created
     * @param req The table details as dto
     * @param status Set status of table visibility for guest
     * @return A new TableModel object with provided details
     * @throws NoRestaurantFoundException If no restaurant is found with the provided id
     */
    public TableModel createTable(Long restaurantId, NewTableReq req, boolean status) throws NoRestaurantFoundException {
        Optional<RestaurantModel> optRestaurant = restaurantRepository.findById(restaurantId);
        if (optRestaurant.isEmpty()) {
            throw new NoRestaurantFoundException("No restaurant found with such an ID");
        }
        TableModel newTable = new TableModel();
        newTable.setSeatsNumbers(req.getSeatNumbers());
        newTable.setVisibleForClient(status);
        newTable.setRestaurant(optRestaurant.get());

        return tableRepository.save(newTable);
    }

    /**
     * Deletes TableModel object by its unique identifier
     *
     * @param id The unique identifier ot table
     * @throws NoTableFoundException If no table is found with the provided id
     */
    public void deleteTableById(Long id) throws NoTableFoundException {
        Optional<TableModel> optTable = tableRepository.findById(id);
        if (!tableRepository.existsById(id)) {
            throw new NoTableFoundException("Can't delete table " +
                    "object because there is no table with such an ID");
        }

        tableRepository.deleteById(id);
    }


}

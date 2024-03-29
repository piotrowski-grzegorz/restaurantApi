package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationHostRepository extends JpaRepository<ReservationModel, Long> {

    public List<ReservationModel> findAllByRestaurantModelId(Long id);

    @Modifying
    @Query("UPDATE ReservationModel e SET e.isConfirmedByHost = :isConfirmed where e.guestPhoneNumber = :guestPhoneNumber")
    void updateReservationModelisConfirmedByHost(String guestPhoneNumber, boolean isConfirmed);

    @Modifying
    @Query("UPDATE ReservationModel e SET e.isRejectedByHost = :isRejected where e.guestPhoneNumber = :guestPhoneNumber")
    void updateReservationModelisRejectedByHost(String guestPhoneNumber, boolean isRejected);


}

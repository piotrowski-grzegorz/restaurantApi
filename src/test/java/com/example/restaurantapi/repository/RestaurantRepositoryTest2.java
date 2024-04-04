package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.AddressModel;
import com.example.restaurantapi.model.entity.RestaurantModel;
import org.hibernate.annotations.processing.SQL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@Sql(scripts = "data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class RestaurantRepositoryTest2 {

@Autowired
    private RestaurantRepository restaurantRepository;

@Test
    void test() {
//    //given
//    var restaurant = new RestaurantModel();
//    String typeCuisine = "polska";
//    restaurant.setType(typeCuisine);
//    restaurant.setAddress(new AddressModel(
//            "Wołoska",
//            "3",
//            "5",
//            "00-001",
//            "Warszawa", "Polska"));
//    restaurantRepository.save(restaurant);

    //when
    List<RestaurantModel> restaurants = restaurantRepository.findAllByTypeIgnoreCase("polska");


    //then
    Assertions.assertEquals(4,restaurants.size());


}
}

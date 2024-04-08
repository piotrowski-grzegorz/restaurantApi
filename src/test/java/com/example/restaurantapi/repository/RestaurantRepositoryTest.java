package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.entity.RestaurantModel;
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
class RestaurantRepositoryTest {

@Autowired
    private RestaurantRepository restaurantRepository;

@Test
    void findAllRestaurantsByName_ShouldAmountOfRestaurants() {

    //when
    List<RestaurantModel> restaurants = restaurantRepository.findAllByTypeIgnoreCase("polska");


    //then
    Assertions.assertEquals(2,restaurants.size());


}
}

package com.example.restaurantapi.model.entity;

import com.example.restaurantapi.model.entity.RestaurantModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
@Table(name = "RATING")
public class RatingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "MARK")
    private Integer mark;
    @Column(name = "REVIEW")
    private String review;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "id")
    @JsonBackReference
    private RestaurantModel restaurant;




}

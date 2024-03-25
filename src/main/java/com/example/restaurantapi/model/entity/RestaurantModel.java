package com.example.restaurantapi.model.entity;

import com.example.restaurantapi.model.AddressModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
//@NoArgsConstructor
//@Getter
//@Setter
@Table(name = "RESTAURANT")
public class RestaurantModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(name = "NAME", unique = false, nullable = false)
    private String name;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "OPEN_HOUR", length = 6, nullable = false)
    private String openHour;
    @Column(name = "CLOSE_HOUR", length = 6, nullable = false)
    private String closeHour;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Set<RatingModel> rating;

    @Column(name = "AVG_MARK")
    private Integer averageMark;

//    private PhotoModel photos;

//    @Column(name = "REVIEW_NUMBER")
//    private Integer reviewNumber;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressModel address;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE, orphanRemoval = true)

    private Set<TableModel> tables;




}

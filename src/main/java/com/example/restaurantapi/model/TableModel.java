package com.example.restaurantapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "TABLES")
public class TableModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Setter(AccessLevel.NONE)
   private Long id;

   @Column(name = "AVAILABILITY")
   private boolean isAvailable;

   @Column(name = "ARRANGMENT")
   private String arrangment;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "RESTAURANT_ID")
   @JsonManagedReference
   private RestaurantModel restaurant;

//   @Enumerated(EnumType.ORDINAL)
//   private TableArrangment tableArrangment;

}

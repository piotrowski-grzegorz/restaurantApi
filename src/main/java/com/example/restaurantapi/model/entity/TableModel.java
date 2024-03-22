package com.example.restaurantapi.model.entity;

import com.example.restaurantapi.model.entity.RestaurantModel;
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

   @Column(name = "ARRANGEMENT")
   private String arrangment;

   @Column(name = "VISIBLE_FOR_CLIENT")
   private boolean isVisibleForClient;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "id")
   @JsonManagedReference
   private RestaurantModel restaurant;



//   @Column(name = "ARRANGMENT_ENUM")
//   @Enumerated(EnumType.ORDINAL)
//   private TableArrangment tableArrangment;

}

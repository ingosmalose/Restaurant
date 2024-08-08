package com.RestaurantMenu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "tbl_restaurant")
@NoArgsConstructor
@AllArgsConstructor

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String phone;
    String Address;
    String email;
    String details;

    //@OneToMany(targetEntity = Menu.class, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    @OneToMany(mappedBy = "restaurant", targetEntity = Menu.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    List<Menu> menu = new ArrayList<>();
}

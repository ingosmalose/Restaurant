package com.RestaurantMenu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Builder
@Table(name = "tbl_reservation")
@NoArgsConstructor
@AllArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String customer;
    String appointment;
    String time;
    String phone;
    String email;
    String details;
    /*
    0 = setting appointment
    1 = waiting list
    2 = on table
    3 = cancel
    4 = done
    */
    Long state;
    Long people;
    
}

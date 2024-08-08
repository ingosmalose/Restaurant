package com.RestaurantMenu.controller.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ReservationDTO {
    
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

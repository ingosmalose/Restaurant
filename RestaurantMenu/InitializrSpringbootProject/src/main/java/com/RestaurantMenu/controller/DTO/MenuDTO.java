package com.RestaurantMenu.controller.DTO;

import com.RestaurantMenu.entities.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
        
public class MenuDTO {

    Long id;
    String name;
    String detail;
    Restaurant restaurant;
}

package com.RestaurantMenu.controller.DTO;

import com.RestaurantMenu.entities.Menu;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RestaurantDTO {

    Long id;
    String name;
    String phone;
    String Address;
    String email;
    String details;
    List<Menu> Menu = new ArrayList<>();
}

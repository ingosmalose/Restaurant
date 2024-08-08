package com.RestaurantMenu.controller.DTO;

import com.RestaurantMenu.entities.Menu;
import java.math.BigDecimal;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PlateDTO {
    Long id;
    String name;
    String detail;
    BigDecimal price;
    Menu menu;
}

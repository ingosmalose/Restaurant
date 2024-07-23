package com.application.rest.controller.implement;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tbl_menuDTO {
    Long id;
    String nmenu;
    String details;
}

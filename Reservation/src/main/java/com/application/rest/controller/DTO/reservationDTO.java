package com.application.rest.controller.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_reserved")
public class reservationDTO {
    Long id;
    String phone;
    String date;
    Integer people;
    Long idclient;   
    String details;
     
}

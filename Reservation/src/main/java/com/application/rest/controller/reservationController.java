package com.application.rest.controller;

import com.application.rest.controller.DTO.reservationDTO;
import com.application.rest.entity.Reservation;
import com.application.rest.service.IReservationService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reservation")
public class reservationController {
    
    @Autowired
    IReservationService reservationService;
    
    private String msg ;
    
    private void setMsg(){
        msg = "API-REST: Reservation.\n"
            + "Version: 1.0\n"
            + "Developer: Oscar M. Lopez";
    }
    
    private String getMsg(){    return msg; }
    
    @GetMapping("/")
    public String index1(){
        setMsg();
        return getMsg();
    }
        
    @GetMapping("/index")
    public String index2(){
        setMsg();
        return getMsg();
    }
    
    @GetMapping("/listAll")
    public ResponseEntity<?> listAll(){
        List<reservationDTO> reservationList = reservationService.listAll()
                .stream()
                .map(
                        Reservation->reservationDTO.builder()
                        .id(Reservation.getId())
                        .phone(Reservation.getPhone())
                        .date(Reservation.getDate())
                        .people(Reservation.getPeople())
                        .details(Reservation.getDetails())
                        .build()
                ).toList();        
        return ResponseEntity.ok(reservationList);        
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody reservationDTO info ) throws URISyntaxException{
        if(info.getDate().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        reservationService.save(Reservation.builder()
                .date(info.getDate())
                .details(info.getDetails())
                .phone(info.getPhone())
                .people(info.getPeople())
                .idclient(info.getIdclient())
                .build()
        );
        return ResponseEntity.created(new URI("/api/reservation/save")).build();
    }
}

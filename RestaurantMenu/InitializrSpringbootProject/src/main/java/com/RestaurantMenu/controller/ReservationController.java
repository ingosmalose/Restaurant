package com.RestaurantMenu.controller;

import com.RestaurantMenu.controller.DTO.ReservationDTO;
import com.RestaurantMenu.entities.Reservation;
import com.RestaurantMenu.service.IReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    
    @Autowired
    IReservationService service;
    
    @GetMapping("/")
    public String index(){
        return "Index";
    }    
    
    @GetMapping("/index")
    public String index2(){
        return "Index";
    }
    
    @GetMapping("/listAll")
    public ResponseEntity<?> listAll(){
        List<ReservationDTO> info = service.listReservation()
                .stream()
                .map(Reservation ->ReservationDTO.builder()                        
                        .id(Reservation.getId())
                        .people(Reservation.getPeople())
                        .state(Reservation.getState())
                        .customer(Reservation.getCustomer())
                        .appointment(Reservation.getAppointment())
                        .time(Reservation.getTime())
                        .phone(Reservation.getPhone())
                        .email(Reservation.getEmail())
                        .details(Reservation.getDetails())
                        .build()
                ).toList();
        
        return ResponseEntity.ok(info);
    }
    //*
    @GetMapping("/searchByDate/{dBegin}/{dEnding}")
    public ResponseEntity<?> searchByDate(@PathVariable String dBegin, @PathVariable String dEnding ){
        List<ReservationDTO> info =  service.listDate(dBegin, dEnding)
                .stream()
                .map(Reservation ->ReservationDTO.builder()                        
                        .id(Reservation.getId())
                        .people(Reservation.getPeople())
                        .state(Reservation.getState())
                        .customer(Reservation.getCustomer())
                        .appointment(Reservation.getAppointment())
                        .time(Reservation.getTime())
                        .phone(Reservation.getPhone())
                        .email(Reservation.getEmail())
                        .details(Reservation.getDetails())
                        .build()                
                ).toList();
        return ResponseEntity.ok(info);
    }// */
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ReservationDTO info){
        if(info.getEmail().isBlank() || info.getAppointment().isBlank() || info.getCustomer().isBlank() || info.getPhone().isBlank() ){
            return ResponseEntity.notFound().build();
        }
        if(service.limitReservation(info.getAppointment(), info.getTime()) < 3 ){
            Reservation reservation = Reservation.builder()
                .people(info.getPeople())
                .state(info.getState())
                .appointment(info.getAppointment())
                .customer(info.getCustomer())
                .details(info.getDetails())
                .email(info.getEmail())
                .phone(info.getPhone())
                .time(info.getTime())
                .build();
            service.save(reservation);
        }
        else{
            return ResponseEntity.ok("Full Capacity.");
        }
        
        return null;
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ReservationDTO info){
        
        Optional<Reservation> optional = service.findById(id);
        if(optional.isPresent()){
            Reservation data = optional.get();
            data.setAppointment(info.getAppointment());
            data.setCustomer(info.getCustomer());
            data.setDetails(info.getDetails());
            data.setEmail(info.getEmail());
            data.setPeople(info.getPeople());
            data.setPhone(info.getPhone());
            data.setState(info.getState());
            data.setTime(info.getTime());
            service.save(data);
            return ResponseEntity.ok("Reservation updated");
        }        
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(id!=null){
            service.delete(id);
            return ResponseEntity.ok("Rservation deleted");
        }
        return ResponseEntity.badRequest().build();
    }
    
}

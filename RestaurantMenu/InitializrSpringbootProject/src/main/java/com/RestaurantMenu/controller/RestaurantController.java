package com.RestaurantMenu.controller;

import com.RestaurantMenu.controller.DTO.RestaurantDTO;
import com.RestaurantMenu.entities.Restaurant;
import com.RestaurantMenu.service.IRestaurantService;
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
@RequestMapping("/api/restaurant")
public class RestaurantController {
    @Autowired
    private IRestaurantService service;
    
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
        List<RestaurantDTO> list = service.listRestaurant()
                .stream()
                .map(Restaurant->RestaurantDTO.builder()                        
                        .id(Restaurant.getId())
                        .Address(Restaurant.getAddress())
                        .details(Restaurant.getDetails())
                        .email(Restaurant.getEmail())
                        .name(Restaurant.getName())
                        .phone(Restaurant.getPhone())
                        .Menu(Restaurant.getMenu())
                        .build()
                )
                .toList();
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Restaurant> optional = service.findById(id);
        if(optional.isPresent()){
            Restaurant info = optional.get();
            RestaurantDTO dto = RestaurantDTO.builder()
                    .id(info.getId())
                    .name(info.getName())
                    .Address(info.getAddress())
                    .email(info.getEmail())
                    .phone(info.getPhone())
                    .details(info.getDetails())
                    .Menu(info.getMenu())
                    .build();
            return ResponseEntity.ok(dto);
        }
        
        return ResponseEntity.notFound().build();
        
    }
    
    //*
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RestaurantDTO info){
        if( info.getName().isBlank() ){
            return ResponseEntity.badRequest().build();
        }
        
        service.save(Restaurant.builder()
                .name(info.getName())
                .Address(info.getAddress())
                .phone(info.getPhone())
                .email(info.getEmail())
                .details(info.getDetails())
                .build()
        );
        
        return null;        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RestaurantDTO info){
        Optional<Restaurant> optional = service.findById(id);
        if(optional.isPresent()){
            Restaurant restaurant = optional.get();
            restaurant.setAddress(info.getAddress());
            restaurant.setDetails(info.getDetails());
            restaurant.setEmail(info.getEmail());
            restaurant.setName(info.getName());
            restaurant.setPhone(info.getPhone());
            service.save(restaurant);
            return ResponseEntity.ok("info updated");
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(id!=null){
            service.delete(id);
            return ResponseEntity.ok("Row deleted");
        }        
        return ResponseEntity.badRequest().build();
    }
}

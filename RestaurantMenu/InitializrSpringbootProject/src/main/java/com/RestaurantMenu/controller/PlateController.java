package com.RestaurantMenu.controller;

import com.RestaurantMenu.controller.DTO.PlateDTO;
import com.RestaurantMenu.entities.Plate;
import com.RestaurantMenu.service.IPlateService;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plate")
public class PlateController {
    @Autowired
    IPlateService service;
    
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
        List<PlateDTO> list = service.listAll()
                .stream()
                .map(Plate->PlateDTO.builder()
                        .id(Plate.getId())
                        .name(Plate.getName())
                        .detail(Plate.getDetail())
                        .price(Plate.getPrice())
                        .menu(Plate.getMenu())
                        .build()                
                ).toList();        
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id){
        Optional<Plate> list = service.findById(id);
        if(list.isPresent()){
            Plate info = list.get();
            PlateDTO dto = PlateDTO.builder()
                    .id(info.getId())
                    .name(info.getName())
                    .detail(info.getDetail())
                    .price(info.getPrice())
                    .menu(info.getMenu())
                    .build();
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PlateDTO info){
        if(info.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        Plate insert = Plate.builder()
                .name(info.getName())
                .detail(info.getDetail())
                .price(info.getPrice())
                .menu(info.getMenu())
                .build();
        service.save(insert);
        return null;
    }
}

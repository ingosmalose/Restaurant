package com.RestaurantMenu.controller;

import com.RestaurantMenu.service.IMenuService;
import com.RestaurantMenu.controller.DTO.MenuDTO;
import com.RestaurantMenu.entities.Menu;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private IMenuService service;
    
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
        List<MenuDTO> list = service.ListMenu()
                .stream()
                .map(Menu->MenuDTO.builder()
                .id(Menu.getId())
                .name(Menu.getName())
                .detail(Menu.getDetail())
                .restaurant(Menu.getRestaurant())
                .build()
                ).toList();
        return ResponseEntity.ok(list);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MenuDTO info) throws URISyntaxException{
        if(info.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        
        Menu menu = Menu.builder()
                .name(info.getName())
                .restaurant(info.getRestaurant())
                .detail(info.getDetail())
                .build();
        service.save(menu);
        return ResponseEntity.created(new URI("/api/menu/save")).build();
    }
    
   @PutMapping("/update/{id}")
   public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MenuDTO info){
       Optional<Menu> optional = service.FindById(id);
       if(optional.isPresent()){
           Menu menu = optional.get();
           menu.setDetail(info.getDetail());
           menu.setName(info.getName());
           menu.setRestaurant(info.getRestaurant());
           service.save(menu);
           return ResponseEntity.ok("Menu updated");
       }
       return ResponseEntity.notFound().build();
   }

}

package com.application.rest.controller;
//*
import com.application.rest.controller.implement.tbl_menuDTO;
import com.application.rest.entities.tbl_menu;
import com.application.rest.service.IMenuService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;//   */
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/menu")
public class menuController {
    //*
    @Autowired
    private IMenuService menuService;// */
    
    @GetMapping("/")
    public String index1(){
        return "ing.osmalose";
    }
    @GetMapping("/index")
    public String index2(){
        return "Index menu";
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<?>listAll(){
        List<tbl_menuDTO> menuList = menuService.listAll()
                .stream()
                .map(
                        tbl_menu->tbl_menuDTO.builder()
                        .id(tbl_menu.getId())
                        .nmenu(tbl_menu.getNmenu())
                        .details(tbl_menu.getDetails())
                        .build()
                ).toList();        
        return ResponseEntity.ok(menuList);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody tbl_menuDTO info) throws URISyntaxException{
        if(info.getNmenu().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        menuService.save(tbl_menu.builder()
                .nmenu(info.getNmenu())
                .details(info.getDetails())
                .build());
        return ResponseEntity.created(new URI("/api/menu/save")).build();        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody tbl_menuDTO info){
        Optional<tbl_menu> menu = menuService.findById(id);
        if(menu.isPresent()){
            tbl_menu tMenu = menu.get();
            tMenu.setNmenu(info.getNmenu());
            tMenu.setDetails(info.getDetails());
            menuService.save(tMenu);
            return ResponseEntity.ok("Updated menu");
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(id!=null){
            menuService.deleteById(id);
            return ResponseEntity.ok("Producto deleted ");                    
        }        
        return ResponseEntity.notFound().build();
    }
}

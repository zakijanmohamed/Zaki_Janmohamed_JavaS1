package com.GameStore.ZakiJanmohamedU1Capstone.controller;

import com.GameStore.ZakiJanmohamedU1Capstone.model.Game;
import com.GameStore.ZakiJanmohamedU1Capstone.model.T_Shirt;
import com.GameStore.ZakiJanmohamedU1Capstone.service.InvoiceInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class T_ShirtInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    //add
    @RequestMapping(value = "/t_shirt", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public T_Shirt createT_Shirt (@RequestBody @Valid T_Shirt t_shirt){
        return inventoryService.addT_shirt(t_shirt);
    }

    //getById
    @RequestMapping(value = "/t_shirt/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public T_Shirt getT_shirtById (@PathVariable int t_shirt_id){
        return inventoryService.getT_shirtById(t_shirt_id);
    }

    //getAll
    @RequestMapping(value = "/t_shirt", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<T_Shirt> getAllT_shirt(){
        return inventoryService.getAllTees();
    }

    //getByColor
    @RequestMapping(value = "/t_shirt/{color}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<T_Shirt> getT_shirtByColor (@PathVariable String color){
        return inventoryService.findTeeByColor(color);
    }

    //getBySize
    @RequestMapping(value = "/t_shirt/{size}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<T_Shirt> getT_shirtBySize (@PathVariable String size){
        return inventoryService.findTeeBySize(size);
    }

    //update
    @RequestMapping(value = "/t_shirt/{t_shirt_id}", method =RequestMethod.PUT)
    @ResponseStatus (value = HttpStatus.OK)
    public void updateT_shirt (@PathVariable T_Shirt t_shirt){
        inventoryService.updates_T_shirt(t_shirt);
    }

    //delete
    @RequestMapping(value = "/t_shirt/{t_shirt_id}", method = RequestMethod.DELETE)
    @ResponseStatus(value =HttpStatus.NO_CONTENT)
    public void deleteT_shirt (@PathVariable int t_shirt_id){
        inventoryService.remove_T_Shirt(t_shirt_id);
    }
}

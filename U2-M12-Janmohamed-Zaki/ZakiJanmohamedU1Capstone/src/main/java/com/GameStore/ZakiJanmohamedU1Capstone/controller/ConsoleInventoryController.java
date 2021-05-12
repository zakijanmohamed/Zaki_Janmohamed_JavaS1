package com.GameStore.ZakiJanmohamedU1Capstone.controller;

import com.GameStore.ZakiJanmohamedU1Capstone.model.Console;
import com.GameStore.ZakiJanmohamedU1Capstone.model.Game;
import com.GameStore.ZakiJanmohamedU1Capstone.service.InvoiceInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConsoleInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    //add
    @RequestMapping(value = "/console", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console createConsole (@RequestBody @Valid Console console){
        return inventoryService.AddsConsole(console);
    }

    //getById
    @RequestMapping(value = "/console/id/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Console getConsoleById (@PathVariable int id){
        return inventoryService.getConsoleById(id);
    }

    //getAll
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getAllConsole(){
        return inventoryService.getAllConsoles();
    }

    //getByManufacturer
    @RequestMapping(value = "/console/manufacturer/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getConsoleByManufacturer (@PathVariable String manufacturer){
        return inventoryService.findConsoleByManufacturer(manufacturer);
    }

    //delete
    @RequestMapping(value = "/console/delete/{console_id}", method = RequestMethod.DELETE)
    @ResponseStatus(value =HttpStatus.NO_CONTENT)
    public void deleteConsole (@PathVariable int console_id){
        inventoryService.removeConsole(console_id);
    }

    //update
    @RequestMapping(value = "/console/{console_id}", method =RequestMethod.PUT)
    @ResponseStatus (value = HttpStatus.OK)
    public void updateConsole (@PathVariable int console_id,@RequestBody Console console){
        inventoryService.updatesConsole(console);
    }
}

package com.GameStore.ZakiJanmohamedU1Capstone.controller;


import com.GameStore.ZakiJanmohamedU1Capstone.dao.GameDao;
import com.GameStore.ZakiJanmohamedU1Capstone.model.Console;
import com.GameStore.ZakiJanmohamedU1Capstone.model.Game;
import com.GameStore.ZakiJanmohamedU1Capstone.service.InvoiceInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class GameInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    //add
    @RequestMapping(value = "/game", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game createGame (@RequestBody @Valid Game game){
              return inventoryService.AddsGame(game);
    }

    //getById
    @RequestMapping(value = "/game/id/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById (@PathVariable int id){
        return inventoryService.getGameById(id);
    }

    //getAll

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames(){
        return inventoryService.getAllGames();
    }


    //getByStudio
    @RequestMapping(value = "/game/studio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByStudio (@PathVariable String studio){
        return inventoryService.findGamesByStudio(studio);
    }

    //getByRating
    @RequestMapping(value = "/game/rating/{rating}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByRating (@PathVariable String rating){
        return inventoryService.findGamesByRating(rating);
    }

    //getByTitle
    @RequestMapping(value = "/game/title/{title}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByTitle (@PathVariable String title){
        return inventoryService.findGamesByTitle(title);
    }

    //delete
    @RequestMapping(value = "/game/delete/{game_id}", method = RequestMethod.DELETE)
    @ResponseStatus(value =HttpStatus.NO_CONTENT)
    public void deleteGame (@PathVariable int game_id){
         inventoryService.removeGame(game_id);
    }

    //update
    @RequestMapping(value = "/game/{game_id}", method =RequestMethod.PUT)
    @ResponseStatus (value = HttpStatus.OK)
    public void updateGame (@PathVariable int game_id,@RequestBody Game game){
        inventoryService.UpdatesGame(game);
    }

}

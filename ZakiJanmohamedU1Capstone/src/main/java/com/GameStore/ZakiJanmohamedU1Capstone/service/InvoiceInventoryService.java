package com.GameStore.ZakiJanmohamedU1Capstone.service;


import com.GameStore.ZakiJanmohamedU1Capstone.dao.*;
import com.GameStore.ZakiJanmohamedU1Capstone.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
public class InvoiceInventoryService {

    GameDao gameDao;
    ConsoleDao consoleDao;
    T_ShirtDao t_shirtDao;
    InvoiceDao invoiceDao;
    SalesTaxRateDao salesTaxRateDao;
    ProcessingFeeDao processingFeeDao;

    @Autowired
    public InvoiceInventoryService(GameDao gameDao, ConsoleDao consoleDao, T_ShirtDao t_shirtDao, InvoiceDao invoiceDao, SalesTaxRateDao salesTaxRateDao, ProcessingFeeDao processingFeeDao) {
        this.gameDao = gameDao;
        this.consoleDao = consoleDao;
        this.t_shirtDao = t_shirtDao;
        this.invoiceDao = invoiceDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.processingFeeDao = processingFeeDao;
    }

                            //------------------Game----------------//

    //add
    @Transactional
    public Game AddsGame(Game game) {

        Game game1 = new Game();
        game1.setTitle(game.getTitle());
        game1.setEsrb_rating(game.getEsrb_rating());
        game1.setDescription(game.getDescription());
        game1.setPrice(game.getPrice());
        game1.setStudio(game.getStudio());
        game1.setQuantity(game.getQuantity());

        game.setGame_id(game.getGame_id());

        return game;
    }

    //update
    public void UpdatesGame(Game game) {

        Game game1 = new Game();
        game1.setGame_id(game.getGame_id());
        game1.setTitle(game.getTitle());
        game1.setEsrb_rating(game.getEsrb_rating());
        game1.setDescription(game.getDescription());
        game1.setPrice(game.getPrice());
        game1.setStudio(game.getStudio());
        game1.setQuantity(game.getQuantity());

        gameDao.updateGame(game1);
    }

    //delete
    public void removeGame(int game_id) {
        gameDao.deleteGame(game_id);
    }

    //get
    public Game getGameById(int game_id) {
        Game game = gameDao.getGame(game_id);
        if (game == null)
            return null;
        else return game;
    }

    //getAll
    public List<Game> getAllGames() {
        return gameDao.getAllGame();
    }

    //getByStudio
    public List<Game> findGamesByStudio(String studio) {
        return gameDao.getGamesByStudio(studio);
    }

    //getByRating
    public List<Game> findGamesByRating(String esrb_rating) {
        return gameDao.getGamesByRating(esrb_rating);
    }

    //getByTitle
    public List<Game> findGamesByTitle(String title) {
        return gameDao.getGamesByTitle(title);
    }

                        //-------------------------Console--------------------------//

//add
@Transactional
public Console AddsConsole(Console console) {

    Console console1 = new Console();
    console1.setModel(console.getModel());
    console1.setManufacturer(console.getManufacturer());
    console1.setMemory_amount(console.getMemory_amount());
    console1.setProcessor(console.getProcessor());
    console.setPrice(console.getPrice());
    console.setQuantity(console.getQuantity());

    console.setConsole_id(console1.getConsole_id());

    return console;
}

    //update
    public void updatesConsole(Console console) {

        Console console1 = new Console();
        console1.setConsole_id(console.getConsole_id());
        console1.setModel(console.getModel());
        console1.setManufacturer(console.getManufacturer());
        console1.setMemory_amount(console.getMemory_amount());
        console1.setProcessor(console.getProcessor());
        console1.setPrice(console.getPrice());
        console1.setQuantity(console.getQuantity());

        consoleDao.updateConsole(console1);
    }

    //delete
    public void removeConsole(int console_id) {
        consoleDao.deleteConsole(console_id);
    }

    //get
    public Console getConsoleById(int console_id) {
        Console console = consoleDao.getConsole(console_id);
        if (console == null)
            return null;
        else return console;
    }

    //getALL
    public List<Console> getAllConsoles() {
        return consoleDao.getAllConsoles();
    }

    //getByManufacturer
    public List<Console> findConsoleByManufacturer(String manufacturer) {
        return consoleDao.getConsoleByManufacturer(manufacturer);
    }

         //-------------------------T-Shirt--------------------------//



}

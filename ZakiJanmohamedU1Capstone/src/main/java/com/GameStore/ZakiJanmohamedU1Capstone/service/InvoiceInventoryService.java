package com.GameStore.ZakiJanmohamedU1Capstone.service;


import com.GameStore.ZakiJanmohamedU1Capstone.dao.*;
import com.GameStore.ZakiJanmohamedU1Capstone.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        return gameDao.addGame(game);
    }

    //update
    public void UpdatesGame(Game game) {
        gameDao.updateGame(game);
    }

    //delete
    public void removeGame(int game_id) {
        gameDao.deleteGame(game_id);
    }

    //get
    public Game getGameById(int game_id) {
        return gameDao.getGame(game_id);
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
        return consoleDao.addConsole(console);
    }

    //update
    public void updatesConsole(Console console) {
        consoleDao.updateConsole(console);
    }

    //delete
    public void removeConsole(int console_id) {
        consoleDao.deleteConsole(console_id);
    }

    //get
    public Console getConsoleById(int console_id) {
        return consoleDao.getConsole(console_id);
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
    //add
    @Transactional
    public T_Shirt addT_shirt(T_Shirt t_shirt) {
        return t_shirtDao.addT_shirt(t_shirt);
    }

    //update
    public void updates_T_shirt(T_Shirt t_shirt) {
        t_shirtDao.updateT_shirt(t_shirt);
    }

    //delete
    public void remove_T_Shirt(int t_shirt_id) {
        t_shirtDao.deleteT_shirt(t_shirt_id);
    }

    //get
    public T_Shirt getT_shirtById(int t_shirt_id) {
        return t_shirtDao.getT_shirt(t_shirt_id);
    }

    //getALL
    public List<T_Shirt> getAllTees() {
        return t_shirtDao.getAllTshirts();
    }

    //getByColor
    public List<T_Shirt> findTeeByColor(String color) {
        return t_shirtDao.getTshirtByColor(color);
    }

    //getBySize
    public List<T_Shirt> findTeeBySize(String size) {
        return t_shirtDao.getTshirtByColor(size);
    }

    //-------------------------Invoice--------------------------//
    Console console;
    Game game;
    T_Shirt t_shirt;
    ProcessingFee processingFee = new ProcessingFee();
    BigDecimal fee;
    BigDecimal subTotal;
    BigDecimal additionalProcessingFee = new BigDecimal("15.49");

    //--------------------------------------------------//
    //add
    @Transactional
    public Invoice addInvoice(Invoice invoice) {

        Invoice invoice1 = new Invoice();
        invoice1.setName(invoice.getName());
        invoice1.setStreet(invoice.getStreet());
        invoice1.setCity(invoice.getCity());
        invoice1.setState(invoice.getState());
        invoice1.setZipcode(invoice.getZipcode());
        invoice1.setItem_type(invoice.getItem_type());
//----------------------------------------------------------------------//
        SalesTaxRate salesTaxRate = salesTaxRateDao.getSalesTaxRate(invoice.getState());

        if (invoice.getItem_type().equals("Consoles")) {
            console = consoleDao.getConsole(invoice.getItem_id());
            subTotal = console.getPrice().multiply(new BigDecimal(invoice.getQuantity())).setScale(2, RoundingMode.HALF_UP);
            if (invoice.getQuantity() <= console.getQuantity()) {
                console.setQuantity(console.getQuantity() - invoice.getQuantity());
                consoleDao.updateConsole(console);
            } else {
                throw new IllegalArgumentException("We don't have enough stock!");
            }
        }
        //------------------//
        else if (invoice.getItem_type().equals("Games")) {
            game = gameDao.getGame(invoice.getItem_id());
            subTotal = game.getPrice().multiply(new BigDecimal(invoice.getQuantity())).setScale(2, RoundingMode.HALF_UP);
            if (invoice.getQuantity() <= game.getQuantity()) {
                game.setQuantity(game.getQuantity() - invoice.getQuantity());
                gameDao.updateGame(game);
            } else {
                throw new IllegalArgumentException("We don't have enough stock!");
            }
        }
        //------------------//
        else if (invoice.getItem_type().equals("T-Shirts")) {
            t_shirt = t_shirtDao.getT_shirt(invoice.getInvoice_id());
            subTotal = t_shirt.getPrice().multiply(new BigDecimal(invoice.getQuantity())).setScale(2, RoundingMode.HALF_UP);
            if (invoice.getQuantity() <= t_shirt.getQuantity()) {
                t_shirt.setQuantity(t_shirt.getQuantity() - invoice.getQuantity());
                t_shirtDao.updateT_shirt(t_shirt);
            } else {
                throw new IllegalArgumentException("We don't have enough stock!");
            }
        }

//---------------------------------------------------------------------------//

        if (invoice.getQuantity() <= 10) {
            processingFee = processingFeeDao.getProcessingFee(processingFee.getProduct_type());
            fee = processingFee.getFee();
        } else if (invoice.getQuantity() > 10) {
            processingFee = processingFeeDao.getProcessingFee(processingFee.getProduct_type());
            fee = processingFee.getFee().add(additionalProcessingFee);
        }

        BigDecimal calculatedTax = subTotal.multiply(salesTaxRate.getRate()).setScale(2, RoundingMode.HALF_UP);
//---------------------------------------------------------------------------//

        invoice1.setItem_id(invoice.getItem_id());
        invoice1.setQuantity(invoice.getQuantity());
        invoice1.setUnit_price(invoice.getUnit_price());
        invoice1.setSubtotal(subTotal);
        invoice1.setTax(calculatedTax);
        invoice1.setProcessing_fee(invoice.getProcessing_fee());

        BigDecimal total = subTotal.add(calculatedTax).add(fee);
        invoice1.setTotal(total);

        return invoiceDao.addInvoice(invoice1);
    }


}

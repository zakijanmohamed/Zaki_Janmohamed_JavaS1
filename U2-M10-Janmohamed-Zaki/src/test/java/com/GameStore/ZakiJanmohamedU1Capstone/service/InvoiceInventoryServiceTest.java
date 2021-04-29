package com.GameStore.ZakiJanmohamedU1Capstone.service;

import com.GameStore.ZakiJanmohamedU1Capstone.dao.*;
import com.GameStore.ZakiJanmohamedU1Capstone.model.Console;
import com.GameStore.ZakiJanmohamedU1Capstone.model.Game;
import com.GameStore.ZakiJanmohamedU1Capstone.model.Invoice;
import com.GameStore.ZakiJanmohamedU1Capstone.model.T_Shirt;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class InvoiceInventoryServiceTest {

    ConsoleDao consoleDao;
    GameDao gameDao;
    InvoiceDao invoiceDao;
    T_ShirtDao t_shirtDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    InvoiceInventoryService invoiceInventoryService;

    @Before
    public void setUp() throws Exception {

        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpInvoiceDaoMock();
        setUpT_shirtDaoMock();
//        setUpProcessingFeeDaoMock();
//        setUpSalesTaxRateDaoMock();

    }

    private void setUpConsoleDaoMock(){

        consoleDao = mock(ConsoleDaoJdbcTemplateImplementation.class);

        Console console = new Console();
        console.setConsole_id(1);
        console.setModel("PlayStation 4");
        console.setManufacturer("SonyE");
        console.setMemory_amount("8GB");
        console.setProcessor("µArch");
        console.setPrice(new BigDecimal("14.99"));
        console.setQuantity(4);

        Console console1 = new Console();

        console1.setModel("PlayStation 4");
        console1.setManufacturer("Sony");
        console1.setMemory_amount("8GB");
        console1.setProcessor("µArch");
        console1.setPrice(new BigDecimal("14.99"));
        console1.setQuantity(4);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);

        doReturn(console).when(consoleDao).addConsole(console1);
        doReturn(console).when(consoleDao).getConsole(1);
        doReturn(consoleList).when(consoleDao).getAllConsoles();

        }

    private void setUpGameDaoMock(){

        gameDao = mock(GameDaoJdbcImplementation.class);

         Game game = new Game();
         game.setGame_id(3);
        game.setTitle("Grand Theft Auto V");
        game.setEsrb_rating("M");
        game.setDescription("Assume the role of 3 characters in a city called Los Santos");
        game.setPrice(new BigDecimal("1.49"));
        game.setStudio("Rockstar Games");
        game.setQuantity(8);

        Game game1 = new Game();
        game1.setTitle("Need for Speed");
        game1.setEsrb_rating("T");
        game1.setDescription("Put your crocs into race car mode and go vroom vroom");
        game1.setPrice(new BigDecimal("1.49"));
        game1.setStudio("Slightly Mad Studio");
        game1.setQuantity(2);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);

        doReturn(game).when(gameDao).addGame(game1);
        doReturn(game).when(gameDao).getGame(3);
        doReturn(gameList).when(gameDao).getAllGame();
    }

    private void setUpInvoiceDaoMock(){

        invoiceDao = mock(InvoiceDaoJdbcImplementation.class);

         Invoice invoice = new Invoice();
         invoice.setInvoice_id(4);
        invoice.setName("Bob Builder");
        invoice.setStreet("Can we Fix It road");
        invoice.setCity("No");
        invoice.setState("TX");
        invoice.setZipcode("00000");
        invoice.setItem_type("Console");
        invoice.setItem_id(3);
        invoice.setUnit_price(new BigDecimal("14.99"));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("14.99"));
        invoice.setTax(new BigDecimal(".03"));
        invoice.setProcessing_fee(new BigDecimal("3.00"));
        invoice.setTotal(new BigDecimal("22.48"));

         Invoice invoice1 = new Invoice();
        invoice1.setName("Joe Cotton");
        invoice1.setStreet("Eye road.");
        invoice1.setCity("No");
        invoice1.setState("TX");
        invoice1.setZipcode("00001");
        invoice1.setItem_type("Console");
        invoice1.setItem_id(2);
        invoice1.setUnit_price(new BigDecimal("14.99"));
        invoice1.setQuantity(1);
        invoice1.setSubtotal(new BigDecimal("14.99"));
        invoice1.setTax(new BigDecimal(".03"));
        invoice1.setProcessing_fee(new BigDecimal("3.00"));
        invoice1.setTotal(new BigDecimal("22.48"));

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);

    }
    private void setUpT_shirtDaoMock(){

        t_shirtDao = mock(T_shirtDaoJdbcImplementation.class);

        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setT_shirt_id(5);
        t_shirt.setSize("small");
        t_shirt.setColor("white");
        t_shirt.setDescription("White T-shirt");
        t_shirt.setPrice(new BigDecimal("1.98"));
        t_shirt.setQuantity(2);

         T_Shirt t_shirt1 = new T_Shirt();
        t_shirt1.setSize("large");
        t_shirt1.setColor("black");
        t_shirt1.setDescription("black T-shirt");
        t_shirt1.setPrice(new BigDecimal("1.98"));
        t_shirt1.setQuantity(2);

        List<T_Shirt> t_shirtList = new ArrayList<>();
        t_shirtList.add(t_shirt);

        doReturn(t_shirt).when(t_shirtDao).addT_shirt(t_shirt1);
        doReturn(t_shirt).when(t_shirtDao).getT_shirt(5);
        doReturn(t_shirtList).when(t_shirtDao).getAllTshirts();
    }

    @Test
    public void shouldAddGetDeleteConsole(){

//        consoleDao.addConsole(invoiceInventoryService.console);
//        Console console =consoleDao.getConsole(consoleDao.getConsole());
//        assertEquals(console,consoleDao);
//        consoleDao.deleteConsole(console.getConsole_id());

    }

    }

package com.GameStore.ZakiJanmohamedU1Capstone.dao;

import com.GameStore.ZakiJanmohamedU1Capstone.model.Console;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoJdbcTemplateImplementationTest {

    @Autowired
    ConsoleDao consoleDao;

    private Console console;

    @Before
    public void setUp() throws Exception {
        clearDataBase();
        setUpTestObjects();
    }
    public void clearDataBase(){
        List<Console> consoles = consoleDao.getAllConsoles();
        for (Console console:consoles){
            consoleDao.deleteConsole(console.getConsole_id());
        }
    }
    public void setUpTestObjects(){
        console = new Console();
        console.setModel("PlayStation 4");
        console.setManufacturer("Sony");
        console.setMemory_amount("8GB");
        console.setProcessor("µArch");
        console.setPrice(new BigDecimal("14.99"));
        console.setQuantity(4);
    }


    @Test
    public void shouldAddGetDeleteConsole(){
        console = consoleDao.addConsole(console);
        Console console1 = consoleDao.getConsole(console.getConsole_id());
        assertEquals(console1,console);
        consoleDao.deleteConsole(console.getConsole_id());
    }

    @Test
    public void shouldGetAllConsoles(){

        console = consoleDao.addConsole(console);

        console = new Console();
        console.setModel("PlayStation 4");
        console.setManufacturer("Sony");
        console.setMemory_amount("16GB");
        console.setProcessor("µArch");
        console.setPrice(new BigDecimal("14.99"));
        console.setQuantity(5);

        consoleDao.addConsole(console);

        List<Console> consoleList = consoleDao.getAllConsoles();
        assertEquals(2,consoleList.size());

    }

    @Test
    public void shouldUpdateConsole(){
        console = consoleDao.addConsole(console);

        console.setModel("PlayStation 7");
        console.setManufacturer("Sony");
        console.setMemory_amount("16GB");
        console.setProcessor("µArch Updated");
        console.setPrice(new BigDecimal("14.99"));
        console.setQuantity(2);

        consoleDao.updateConsole(console);

        Console console1 =consoleDao.getConsole(console.getConsole_id());
        assertEquals(console1,console);

    }

    @Test
    public void shouldGetConsoleByManufacturer(){

        console = consoleDao.addConsole(console);

        Console console1 = new Console();
        console1.setModel("Xbox 360");
        console1.setManufacturer("Microsoft");
        console1.setMemory_amount("16GB");
        console1.setProcessor("idk what they use");
        console1.setPrice(new BigDecimal("14.99"));
        console1.setQuantity(2);

        consoleDao.addConsole(console1);

        List<Console> consoleList = consoleDao.getConsoleByManufacturer(console.getManufacturer());
        assertEquals(1,consoleList.size());

        List<Console> consoleList1 = consoleDao.getConsoleByManufacturer(console1.getManufacturer());
        assertEquals(1,consoleList1.size());
    }
}
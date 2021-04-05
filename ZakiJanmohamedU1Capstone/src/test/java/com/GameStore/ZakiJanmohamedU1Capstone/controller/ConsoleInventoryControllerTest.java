package com.GameStore.ZakiJanmohamedU1Capstone.controller;

import com.GameStore.ZakiJanmohamedU1Capstone.dao.ConsoleDao;
import com.GameStore.ZakiJanmohamedU1Capstone.model.Console;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleInventoryController.class)
public class ConsoleInventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsoleDao repo;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createConsole()  throws  Exception {
        Console inputConsole = new Console();

        inputConsole.setModel("PlayStation 4");
        inputConsole.setManufacturer("Sony");
        inputConsole.setMemory_amount("16GB");
        inputConsole.setProcessor("µArch");
        inputConsole.setPrice(new BigDecimal("14.99"));
        inputConsole.setQuantity(5);

        String inputJson = mapper.writeValueAsString(inputConsole);

        Console outputConsole = new Console();
        outputConsole.setModel("PlayStation 4");
        outputConsole.setManufacturer("Sony");
        outputConsole.setMemory_amount("16GB");
        outputConsole.setProcessor("µArch");
        outputConsole.setPrice(new BigDecimal("14.99"));
        outputConsole.setQuantity(5);
        outputConsole.setConsole_id(3);

        String outputJson = mapper.writeValueAsString(outputConsole);

        when (repo.addConsole(inputConsole)).thenReturn(outputConsole);

        this.mockMvc.perform(post("/console")
                                    .content(inputJson)
                                     .contentType(MediaType.APPLICATION_JSON)).
                                        andDo(print())
                .andExpect(status().isCreated());


    }

    @Test
    public void getConsoleById() {
    }

    @Test
    public void getAllConsole() {
    }

    @Test
    public void getConsoleByManufacturer() {
    }

    @Test
    public void deleteConsole() {
    }

    @Test
    public void updateConsole() {
    }
}
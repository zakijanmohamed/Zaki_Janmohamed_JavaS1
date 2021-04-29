package com.GameStore.ZakiJanmohamedU1Capstone.controller;


import com.GameStore.ZakiJanmohamedU1Capstone.model.Console;

import com.GameStore.ZakiJanmohamedU1Capstone.model.Invoice;
import com.GameStore.ZakiJanmohamedU1Capstone.service.InvoiceInventoryService;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleInventoryController.class)
public class ConsoleInventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Console inputConsole;
    private Console outputConsole;

    @MockBean
    private InvoiceInventoryService serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        setUpTestObject();
    }

    public void setUpTestObject(){
         inputConsole = new Console();
        inputConsole.setModel("PlayStation 4");
        inputConsole.setManufacturer("Sony");
        inputConsole.setMemory_amount("16GB");
        inputConsole.setProcessor("µArch");
        inputConsole.setPrice(new BigDecimal("14.99"));
        inputConsole.setQuantity(5);

         outputConsole = new Console();
        outputConsole.setModel("PlayStation 4");
        outputConsole.setManufacturer("Sony");
        outputConsole.setMemory_amount("16GB");
        outputConsole.setProcessor("µArch");
        outputConsole.setPrice(new BigDecimal("14.99"));
        outputConsole.setQuantity(5);
        outputConsole.setConsole_id(3);
    }

    @Test
    public void createConsole()  throws  Exception {

        String inputJsonString = mapper.writeValueAsString(inputConsole);

        String outputJsonString = mapper.writeValueAsString(outputConsole);

        when (serviceLayer.AddsConsole(inputConsole)).thenReturn(outputConsole);

        this.mockMvc.perform(post("/console")
                                    .content(inputJsonString)
                                     .contentType(MediaType.APPLICATION_JSON)).
                                        andDo(print())
                .andExpect(status().isCreated())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(outputJsonString));
    }

    @Test
    public void getConsoleById() throws Exception {
        String outputJsonString = mapper.writeValueAsString(outputConsole);
        mockMvc.perform(
                get("/console/{id}")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(outputJsonString));
    }

    @Test
    public void getAllConsole() throws Exception {

        Console outputConsole1 = new Console();
        outputConsole1.setModel("PlayStation 4");
        outputConsole1.setManufacturer("Sony");
        outputConsole1.setMemory_amount("16GB");
        outputConsole1.setProcessor("µArch");
        outputConsole1.setPrice(new BigDecimal("14.99"));
        outputConsole1.setQuantity(5);
        outputConsole1.setConsole_id(4);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(outputConsole);
        consoleList.add(outputConsole1);
        String outputJsonString = mapper.writeValueAsString(consoleList);
        when(serviceLayer.getAllConsoles()).thenReturn(consoleList);
        mockMvc.perform(
                get("/console")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(outputJsonString));
    }

    @Test
    public void getConsoleByManufacturer() throws Exception{
        String outputJsonString = mapper.writeValueAsString(outputConsole);
        mockMvc.perform(
                get("/console/{color}")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(outputJsonString));
    }

    @Test
    public void deleteConsole() throws Exception {
        Console console = new Console();
        console.setConsole_id(1);
        mockMvc.perform(delete("/console/console_id/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void updateConsole() throws Exception {

        Console console = new Console();
        console.setConsole_id(4);
        console.setModel("PlayStation 4");
        console.setManufacturer("Sony");
        console.setMemory_amount("16GB");
        console.setProcessor("µArch");
        console.setPrice(new BigDecimal("14.99"));
        console.setQuantity(5);

        String inputJsonString = mapper.writeValueAsString(console);
        String outputJsonString =mapper.writeValueAsString(console);

        this.mockMvc.perform(put("console/{console_id}"+console.getConsole_id())
                .content(inputJsonString)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }
}
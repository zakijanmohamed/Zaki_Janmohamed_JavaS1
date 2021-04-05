package com.GameStore.ZakiJanmohamedU1Capstone.controller;

import com.GameStore.ZakiJanmohamedU1Capstone.model.T_Shirt;
import com.GameStore.ZakiJanmohamedU1Capstone.service.InvoiceInventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(T_ShirtInventoryController.class)

public class T_ShirtInventoryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private T_Shirt inputT_shirt;
    private T_Shirt outputT_shirt;


    private ObjectMapper mapper = new ObjectMapper();
    @MockBean
    private InvoiceInventoryService serviceLayer;

    @Before
    public void setUp() throws Exception {
        setUpTestObject();
    }

    public void setUpTestObject() {
        T_Shirt inputT_shirt = new T_Shirt();
        inputT_shirt.setColor("Black");
        inputT_shirt.setSize("Large");
        inputT_shirt.setDescription("Black T_shirt");
        inputT_shirt.setPrice(new BigDecimal("2.99"));
        inputT_shirt.setQuantity(1);
        inputT_shirt.setT_shirt_id(1);

        outputT_shirt = new T_Shirt();
        outputT_shirt.setColor("White");
        outputT_shirt.setSize("small");
        outputT_shirt.setDescription("Small White t-shirt");
        outputT_shirt.setPrice(new BigDecimal("2.99"));
        outputT_shirt.setQuantity(1);
        outputT_shirt.setT_shirt_id(2);
        List<T_Shirt> t_shirtList = new ArrayList<>();
        t_shirtList.add(inputT_shirt);
        t_shirtList.add(outputT_shirt);

    }

    @Test
    public void shouldAddT_shirt() throws Exception {
        String inputJsonString = mapper.writeValueAsString(inputT_shirt);
        String outputJsonString = mapper.writeValueAsString(outputT_shirt);
        when(serviceLayer.addT_shirt(inputT_shirt)).thenReturn(outputT_shirt);
        mockMvc.perform(
                post("/t_shirt")
                        .content(inputJsonString)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJsonString));
    }

    @Test
    public void shouldGetT_shirtById() throws Exception {
        String outputJsonString = mapper.writeValueAsString(outputT_shirt);
        mockMvc.perform(
                get("/t_shirt/{id}")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJsonString));

    }

    @Test
    public void getAllT_shirts() throws Exception {
        T_Shirt outputT_shirt1 = new T_Shirt();
        outputT_shirt1.setColor("Black");
        outputT_shirt1.setSize("Large");
        outputT_shirt1.setDescription("Large Black Tee");
        outputT_shirt1.setPrice(new BigDecimal("2.99"));
        outputT_shirt1.setQuantity(4);
        outputT_shirt1.setT_shirt_id(3);
        List<T_Shirt> t_shirtList = new ArrayList<>();
        t_shirtList.add(outputT_shirt);
        t_shirtList.add(outputT_shirt1);
        String outputJsonString = mapper.writeValueAsString(t_shirtList);
        when(serviceLayer.getAllTees()).thenReturn(t_shirtList);
        mockMvc.perform(
                get("/tshirt")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJsonString));
    }


    @Test
    public void updateT_shirt() throws Exception {
        String inputJsonString = mapper.writeValueAsString(inputT_shirt);

        when(serviceLayer.addT_shirt(inputT_shirt)).thenReturn(outputT_shirt);
        mockMvc.perform(
                put("/t_shirt/{t_shirt_id}")
                        .content(inputJsonString)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteT_shirt() throws Exception{
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setT_shirt_id(1);
        mockMvc.perform(delete("/t_shirt/t_shirt_id/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
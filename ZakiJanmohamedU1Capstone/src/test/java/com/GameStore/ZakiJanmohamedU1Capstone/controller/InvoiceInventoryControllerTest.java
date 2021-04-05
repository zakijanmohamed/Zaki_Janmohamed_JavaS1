package com.GameStore.ZakiJanmohamedU1Capstone.controller;

import com.GameStore.ZakiJanmohamedU1Capstone.model.Invoice;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceInventoryController.class)
public class InvoiceInventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Invoice inputInvoice;


    @MockBean
    private InvoiceInventoryService serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        setUpTestObject();
    }
    public void setUpTestObject(){
         inputInvoice = new Invoice();
        inputInvoice.setInvoice_id(1);
        inputInvoice.setName("Bob Builder");
        inputInvoice.setStreet("Can we Fix It road");
        inputInvoice.setCity("No");
        inputInvoice.setState("TX");
        inputInvoice.setZipcode("00000");
        inputInvoice.setItem_type("Console");
        inputInvoice.setItem_id(3);
        inputInvoice.setUnit_price(new BigDecimal("14.99"));
        inputInvoice.setQuantity(1);
        inputInvoice.setSubtotal(new BigDecimal("14.99"));
        inputInvoice.setTax(new BigDecimal(".03"));
        inputInvoice.setProcessing_fee(new BigDecimal("3.00"));
        inputInvoice.setTotal(new BigDecimal("22.48"));
    }

    @Test
    public void createInvoice() throws Exception{
        String inputJsonString = mapper.writeValueAsString(inputInvoice);
                when(serviceLayer.addInvoice(inputInvoice)).thenReturn(inputInvoice);
        mockMvc.perform(
                post("/invoice")
                        .content(inputJsonString)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(inputJsonString));
    }
}
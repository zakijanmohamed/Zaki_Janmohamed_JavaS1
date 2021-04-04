package com.GameStore.ZakiJanmohamedU1Capstone.controller;

import com.GameStore.ZakiJanmohamedU1Capstone.model.Game;
import com.GameStore.ZakiJanmohamedU1Capstone.model.Invoice;
import com.GameStore.ZakiJanmohamedU1Capstone.service.InvoiceInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class InvoiceInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    //add
    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice createInvoice (@RequestBody @Valid Invoice invoice){
        return inventoryService.addInvoice(invoice);
    }
}

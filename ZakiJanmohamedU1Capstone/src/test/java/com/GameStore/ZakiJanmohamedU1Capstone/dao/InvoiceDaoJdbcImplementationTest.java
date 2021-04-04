package com.GameStore.ZakiJanmohamedU1Capstone.dao;

import com.GameStore.ZakiJanmohamedU1Capstone.model.Invoice;
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
public class InvoiceDaoJdbcImplementationTest {

    @Autowired
    InvoiceDao invoiceDao;

    private Invoice invoice;

    @Before
    public void setUp() throws Exception {
        clearDataBase();
        setUpTestObjects();
    }

    public void clearDataBase(){
        List<Invoice> invoices =invoiceDao.getAllInvoices();
        for (Invoice invoice:invoices){
            invoiceDao.deleteInvoice(invoice.getInvoice_id());
        }
    }

    public void setUpTestObjects(){
        invoice = new Invoice();
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
    }

    @Test
    public void shouldAddDeleteInvoice(){
        invoice = invoiceDao.addInvoice(invoice);
        invoiceDao.deleteInvoice(invoice.getInvoice_id());
    }

    @Test
    public void shouldGetAllInvoices(){
        invoice = invoiceDao.addInvoice(invoice);

        invoice = new Invoice();
        invoice.setName("Joe Cotton");
        invoice.setStreet("Eye road.");
        invoice.setCity("No");
        invoice.setState("TX");
        invoice.setZipcode("00001");
        invoice.setItem_type("Console");
        invoice.setItem_id(2);
        invoice.setUnit_price(new BigDecimal("14.99"));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("14.99"));
        invoice.setTax(new BigDecimal(".03"));
        invoice.setProcessing_fee(new BigDecimal("3.00"));
        invoice.setTotal(new BigDecimal("22.48"));

        invoiceDao.addInvoice(invoice);

        List<Invoice> invoiceList =invoiceDao.getAllInvoices();
        assertEquals(2,invoiceList.size());
    }


}
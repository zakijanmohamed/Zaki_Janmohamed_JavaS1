package com.GameStore.ZakiJanmohamedU1Capstone.dao;

import com.GameStore.ZakiJanmohamedU1Capstone.model.ProcessingFee;

import com.GameStore.ZakiJanmohamedU1Capstone.model.SalesTaxRate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateDaoJdbcImplementationTest {

    @Autowired
    protected SalesTaxRateDao salesTaxRateDao;

    @Test
    public void ShouldGetSalesTax(){
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("TX");
        salesTaxRate.setRate(new BigDecimal(".03"));

        SalesTaxRate salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());
        assertEquals(salesTaxRate1, salesTaxRate);



    }
}
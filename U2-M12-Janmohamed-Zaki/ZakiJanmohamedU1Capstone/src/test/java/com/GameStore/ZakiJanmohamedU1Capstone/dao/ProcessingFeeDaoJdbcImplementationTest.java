package com.GameStore.ZakiJanmohamedU1Capstone.dao;

import com.GameStore.ZakiJanmohamedU1Capstone.model.ProcessingFee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoJdbcImplementationTest {

    @Autowired
    protected ProcessingFeeDao processingFeeDao;

    @Test
    public void ShouldGetProcessingFee(){
   ProcessingFee processingFee = new ProcessingFee();
   processingFee.setProduct_type("Consoles");
   processingFee.setFee(new BigDecimal("14.99"));

   ProcessingFee processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProduct_type());
   assertEquals(processingFee1,processingFee);

}

}
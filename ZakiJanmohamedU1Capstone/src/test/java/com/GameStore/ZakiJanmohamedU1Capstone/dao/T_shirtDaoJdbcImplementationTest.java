package com.GameStore.ZakiJanmohamedU1Capstone.dao;

import com.GameStore.ZakiJanmohamedU1Capstone.model.T_Shirt;
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
public class T_shirtDaoJdbcImplementationTest {

    @Autowired
    T_ShirtDao t_shirtDao;

    private T_Shirt t_shirt;

    @Before
    public void setUp() throws Exception {
        clearDataBase();
        setUpTestObjects();
    }
    public void clearDataBase() {
        List<T_Shirt> t_shirts = t_shirtDao.getAllTshirts();
        for (T_Shirt t_shirt : t_shirts) {
            t_shirtDao.deleteT_shirt(t_shirt.getT_shirt_id());
        }
    }


    public void setUpTestObjects() {
      t_shirt = new T_Shirt();
      t_shirt.setSize("Large");
      t_shirt.setColor("Black");
      t_shirt.setDescription("Black T-shirt");
      t_shirt.setPrice(new BigDecimal("1.98"));
      t_shirt.setQuantity(4);
    }

    @Test
    public void shouldAddGetDeleteT_shirts(){
        t_shirt = t_shirtDao.addT_shirt(t_shirt);
        T_Shirt shirt = t_shirtDao.getT_shirt(t_shirt.getT_shirt_id());
        assertEquals(shirt,t_shirt);
        t_shirtDao.deleteT_shirt(t_shirt.getT_shirt_id());
    }

    @Test
    public void shouldgetAllT_shirts(){
        t_shirt = t_shirtDao.addT_shirt(t_shirt);

        t_shirt = new T_Shirt();
        t_shirt.setSize("small");
        t_shirt.setColor("white");
        t_shirt.setDescription("White T-shirt");
        t_shirt.setPrice(new BigDecimal("1.98"));
        t_shirt.setQuantity(2);

        t_shirtDao.addT_shirt(t_shirt);

        List<T_Shirt> t_shirtList = t_shirtDao.getAllTshirts();
        assertEquals(2, t_shirtList.size());
    }

    @Test
    public void shouldUpdateT_shirt(){
        t_shirt = t_shirtDao.addT_shirt(t_shirt);

        t_shirt.setSize("small");
        t_shirt.setColor("white");
        t_shirt.setDescription("White T-shirt");
        t_shirt.setPrice(new BigDecimal("1.98"));
        t_shirt.setQuantity(2);

        t_shirtDao.updateT_shirt(t_shirt);

        T_Shirt t_shirt1 = t_shirtDao.getT_shirt(t_shirt.getT_shirt_id());
        assertEquals(t_shirt1,t_shirt);
    }

    @Test
    public void shouldGetTbyColor(){

        t_shirt = t_shirtDao.addT_shirt(t_shirt);

        List<T_Shirt> t_shirtList =t_shirtDao.getTshirtByColor(t_shirt.getColor());
        assertEquals(1,t_shirtList.size());

        List<T_Shirt>t_shirtList1=t_shirtDao.getTshirtByColor("Yellow");
        assertEquals(0,t_shirtList1.size());

    }
    @Test
    public void shouldGetTbySize(){

        t_shirt = t_shirtDao.addT_shirt(t_shirt);

        List<T_Shirt> t_shirtList =t_shirtDao.getTshirtBySize(t_shirt.getSize());
        assertEquals(1,t_shirtList.size());

        List<T_Shirt>t_shirtList1=t_shirtDao.getTshirtBySize("small");
        assertEquals(0,t_shirtList1.size());

    }

}
package com.telecom.appnmt.Dao;

import com.telecom.appnmt.Entity.Hall;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HallDaoTest {

    @Autowired
    private HallDao hallDao;

//    @Test
    public void findAllByHallId() throws Exception {
        System.out.println("++++++++ size = "+hallDao.findAllByHallId("123456").size()+" ++++++");
    }

//    @Test
    public void findByHallId() throws Exception {
        System.out.println("++++++++ name = "+hallDao.findByHallId("123456").getHallName()+" ++++++");
    }

    @Test
    public void countTest() throws Exception {
        System.out.println("++++++++ count = "+hallDao.count() +" ++++++");
        // System.out.println("++++++++ count = "+hallDao.countAll() +" ++++++");
    }


}
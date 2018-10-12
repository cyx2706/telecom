package com.telecom.appnmt.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HallServiceTest {

    @Autowired
    private HallService hallService;

//    @Test
    public void a() throws Exception{
        hallService.create();
    }

    @Test
    public void b() throws Exception{
        System.out.println("+++++++++++++++++++++ name = "+hallService.getListByPage(0).get(0).getHallAccount()+" +++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++ name = "+hallService.getListByPage(1).get(0).getHallAccount()+" +++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++ name = "+hallService.getListByPage(2).get(0).getHallAccount()+" +++++++++++++++++++++");
    }

}
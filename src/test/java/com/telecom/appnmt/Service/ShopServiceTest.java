package com.telecom.appnmt.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTest {

    @Autowired
    private ShopService shopService;

    @Test
    public void create() throws Exception {
        shopService.create("123456");
    }

}
package com.telecom.appnmt.Dao;

import com.telecom.appnmt.Entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试订单CURD,主要是检验实体类字段是否有错、jpa的自动完成是否有误
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {

    @Autowired
    private Order order;

    @Autowired
    private OrderDao orderDao;

    @Test
    public void a() {
        order.setOrdId("123");
        order.setUsrId("123");
        order.setShopId("123");
        order.setSchId(1);
        order.setOrdTel("15013330307");
        order.setOrdAddr("地址是 xxxx");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        order.setOrdTime(date);
        order.setOrdQrcode("NULL");
        try {
            orderDao.save(order);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("创建订单失败,请稍后再试");
        }
    }

}
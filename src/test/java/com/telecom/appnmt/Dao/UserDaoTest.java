package com.telecom.appnmt.Dao;

import com.telecom.appnmt.Entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 测试用户的CURD,主要是检验实体类字段是否有错、jpa的自动完成是否有误
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    public User user;

    @Autowired
    public UserDao userDao;

    @Test
    public void a() {
        user.setUsrId("1223");
        user.setUsrTel("15013330307");
        user.setUsrOpenId("123456");
        try {
            userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
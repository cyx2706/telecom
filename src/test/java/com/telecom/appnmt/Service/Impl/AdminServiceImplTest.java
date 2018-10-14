package com.telecom.appnmt.Service.Impl;

import com.telecom.appnmt.Entity.Admin;
import com.telecom.appnmt.Service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void create() throws Exception {
        Admin admin = adminService.create("123","123");
        System.out.println(admin.getAdmId());
    }

    @Test
    public void find() throws Exception {
        Admin admin = adminService.find("123","123");
        System.out.println(admin.getAdmId());
    }

}
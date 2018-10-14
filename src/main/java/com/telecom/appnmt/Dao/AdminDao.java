package com.telecom.appnmt.Dao;

import com.telecom.appnmt.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,String> {

    /**
     * 通过账号和密码寻找管理员用户(实际用于登录)
     * @param account
     * @param passwd
     * @return
     */
    public Admin findByAdmAccountAndAdmPassword(String account,String passwd);
}

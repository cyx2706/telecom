package com.telecom.appnmt.Dao;

import com.telecom.appnmt.Entity.Hall;
import com.telecom.appnmt.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HallDao extends JpaRepository<Hall, String>,JpaSpecificationExecutor<Hall> {

    public Hall findByHallId(String id);

    /**
     * 用于登录的Dao接口,根据账号和密码寻找Hall对象
     * @param account
     * @param password
     * @return
     */
    public Hall findByHallAccountAndHallPassword(String account,String password);
}

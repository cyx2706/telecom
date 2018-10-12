package com.telecom.appnmt.Dao;

import com.telecom.appnmt.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 2018/10/13 00:37:00创建
 * 订单Dao类
 */
public interface OrderDao extends JpaRepository<Order, String> {

}

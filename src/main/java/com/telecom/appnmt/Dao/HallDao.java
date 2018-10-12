package com.telecom.appnmt.Dao;

import com.telecom.appnmt.Entity.Hall;
import com.telecom.appnmt.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HallDao extends JpaRepository<Hall, String>,JpaSpecificationExecutor<Hall> {

    public List<Hall> findAllByHallId(String id);

    public Hall findByHallId(String id);

//    @Query("select *,order from ")
//    public List<Order> findHallOrders();
}

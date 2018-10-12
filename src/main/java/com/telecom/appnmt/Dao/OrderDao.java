package com.telecom.appnmt.Dao;

import com.telecom.appnmt.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * 2018/10/13 00:37:00创建
 * 订单Dao类
 */
public interface OrderDao extends JpaRepository<Order, String> {

    /**
     * 根据营业厅的id统计其下属商店的订单数统计
     * @param hallId
     * @return
     */
    @Query(value = "SELECT shop.shop_name,COUNT(ord.shop_id) AS ord_num FROM `order` AS ord JOIN hall_shop AS hs ON ord.shop_id=hs.shop_id JOIN shop ON shop.shop_id=ord.shop_id WHERE hs.hall_id=?1 GROUP BY ord.shop_id",nativeQuery = true)
    public List<Map<String,Object>> countShopOrderNumByHallId(String hallId);

    /**
     * (暂未完成) 电信公司后台查看所有营业厅的订单数统计
     * @return
     */
    //public List<Map<String,Object>> countHallOrderNum();
}

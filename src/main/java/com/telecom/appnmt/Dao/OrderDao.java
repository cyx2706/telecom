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
    @Query(value = "SELECT shop.shop_name,COUNT(ord.shop_id) AS ord_num FROM `order` AS ord JOIN shop ON shop.shop_id=ord.shop_id WHERE shop.hall_id=?1 GROUP BY ord.shop_id ORDER BY ord.ord_time DESC",nativeQuery = true)
    public List<Map<String,Object>> countShopOrderNumByHallId(String hallId);

    @Query(value = "SELECT ord.*,shop.shop_name AS shop_name FROM `order` AS ord JOIN shop ON shop.shop_id=ord.shop_id WHERE shop.hall_id=?1 ORDER BY ord.ord_time DESC ",nativeQuery = true)
    public List<Map<String,Object>> getAllByHallId(String hallId);

    /**
     * (暂未完成) 电信公司后台查看所有营业厅的订单数统计
     * @return
     */
    //public List<Map<String,Object>> countHallOrderNum();

    /**
     * 根据商店id获得某个商店的所有订单
     * @param shopId
     * @return
     */
    public List<Order> getAllByShopId(String shopId);
}

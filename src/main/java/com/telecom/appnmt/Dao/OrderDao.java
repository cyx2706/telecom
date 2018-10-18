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

    /**
     * 电信公司后台查看所有营业厅的订单数统计
     * @return
     */
    @Query(value = "SELECT SUM(ord_num) AS ord_num,res.hall_id as hall_id,res.hall_name AS hall_name " +
            "FROM (SELECT shop.shop_name,COUNT(ord.shop_id) AS ord_num,hall.hall_id,hall.hall_name FROM `order` AS ord JOIN shop ON shop.shop_id=ord.shop_id JOIN hall ON hall.hall_id=shop.hall_id GROUP BY ord.shop_id) AS res " +
            "GROUP BY res.hall_id",nativeQuery = true)
    public List<Map<String,Object>> countHallOrderNum();

    /**
     * 根据hall_id获取所有相关订单
     * @param hallId
     * @return
     */
    @Query(value = "SELECT ord.*,ord.ord_name AS usr_name,shop.shop_name AS shop_name FROM `order` AS ord JOIN shop ON shop.shop_id=ord.shop_id WHERE shop.hall_id=?1 ORDER BY ord.ord_time DESC ",nativeQuery = true)
    public List<Map<String,Object>> getAllByHallId(String hallId);


    /**
     * 根据商店id获得某个商店的所有订单
     * @param shopId
     * @return
     */
    @Query(value = "SELECT * FROM `order` ord WHERE ord.shop_id=?1 ORDER BY ord.ord_time DESC ",nativeQuery = true)
    public List<Map<String,Object>> getAllByShopId(String shopId);

    /**
     * 用户可获取自己的订单
     * @param usrId
     * @return
     */
    @Query(value = "SELECT ord.*,ord.ord_name AS usr_name,shop.shop_name AS shop_name FROM `order` AS ord JOIN shop ON shop.shop_id=ord.shop_id WHERE ord.usr_id=?1 ORDER BY ord.ord_time DESC ",nativeQuery = true)
    public List<Map<String,Object>> getAllByUsrId(String usrId);

    /**
     * 管理员可以获取所有订单
     * @return
     */
    @Query(value = "SELECT ord.*,ord.ord_name AS usr_name,shop.shop_name AS shop_name,shop.hall_id AS hall_id,hall.hall_name AS hall_name FROM `order` AS ord JOIN shop ON shop.shop_id=ord.shop_id JOIN hall ON shop.hall_id=hall.hall_id ORDER BY ord.ord_time DESC ",nativeQuery = true)
    public List<Map<String,Object>> getAllByAdm();

    /**
     * 根据id获取订单信息
     * @param id
     * @return
     */
    public Order findByOrdId(String id);
}

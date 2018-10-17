package com.telecom.appnmt.Service.Impl;

import com.telecom.appnmt.Dao.OrderDao;
import com.telecom.appnmt.Entity.Order;
import com.telecom.appnmt.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private Order order;

    /**
     * 在营业厅页面获取每个商店所完成订单的数量统计
     * @param hallId
     * @return
     */
    public List<Map<String, Object>> getShopStatisticsAtHallPage(String hallId) {
        return orderDao.countShopOrderNumByHallId(hallId);
    }

    /**
     * 在电信公司管理员页面获取每个营业厅所完成订单的数量统计
     * @return
     */
    @Override
    public List<Map<String, Object>> getHallStatisticsAtAdmPage(String admId) {
        return null;
    }

    /**
     * 商店可获取自己的所有订单列表
     * @param shopId 商店id
     * @param page 默认不分页,如果有分页要求,传入页数为参数即可
     * @return
     */
    public List<Order> getListByShop(String shopId, int page) {
        return null;
    }

    /**
     * @param hallId 营业厅id
     * @param page   默认不分页
     * @return
     */
    @Override
    public List<Map<String, Object>> getListByHall(String hallId, int page) {
        try{
            return orderDao.getAllByHallId(hallId);
        } catch (Exception e) {
            throw new RuntimeException("获取订单列表失败,请稍后再试!");
        }
    }

    /**
     * 用户可以获取自己的订单列表
     * @param usrId 用户id
     * @param page 默认不分页,如果有分页要求,传入页数为参数即可
     * @return
     */
    public List<Order> getListByUser(String usrId, int page) {
        return null;

    }

    /**
     * 营业厅可以自由修改订单状态
     *
     * @param ordId
     * @param status
     * @return
     */
    @Override
    public boolean setOrderStatus(String ordId, int status) {
        order.setOrdId(ordId);
        order.setOrdStatus(status);
        try {
            orderDao.save(order);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("修改订单状态失败!");
        }
    }
}

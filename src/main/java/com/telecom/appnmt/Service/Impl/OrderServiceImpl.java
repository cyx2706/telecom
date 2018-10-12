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
     * 用户可以获取自己的订单列表
     * @param usrId 用户id
     * @param page 默认不分页,如果有分页要求,传入页数为参数即可
     * @return
     */
    public List<Order> getListByUser(String usrId, int page) {
        return null;

    }
}

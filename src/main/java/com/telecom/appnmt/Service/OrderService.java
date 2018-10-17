package com.telecom.appnmt.Service;

import antlr.collections.impl.LList;
import com.telecom.appnmt.Entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    /**
     * 在营业厅页面获取每个商店所完成订单的数量统计
     * @return
     */
    public List<Map<String, Object>> getShopStatisticsAtHallPage(String hallId);

    /**
     * 在电信公司管理员页面获取每个营业厅所完成订单的数量统计
     * @return
     */
    public List<Map<String, Object>> getHallStatisticsAtAdmPage(String admId);

    /**
     * 商店可获取自己的所有订单列表
     * @param shopId 商店id
     * @param page 默认不分页,如果有分页要求,传入页数为参数即可
     * @return
     */
    public List<Order> getListByShop(String shopId,int page);

    /**
     *
     * @param hallId 营业厅id
     * @param page 默认不分页
     * @return
     */
    public List<Map<String,Object>> getListByHall(String hallId,int page);

    /**
     * 用户可以获取自己的订单列表
     * @param usrId 用户id
     * @param page 默认不分页,如果有分页要求,传入页数为参数即可
     * @return
     */
    public List<Order> getListByUser(String usrId,int page);

    /**
     * 营业厅可以自由修改订单状态
     * @param ordId
     * @param status
     * @return
     */
    public boolean setOrderStatus(String ordId,int status);
}

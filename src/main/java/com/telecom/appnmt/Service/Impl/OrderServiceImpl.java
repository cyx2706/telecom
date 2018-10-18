package com.telecom.appnmt.Service.Impl;

import com.telecom.appnmt.Dao.OrderDao;
import com.telecom.appnmt.Entity.Order;
import com.telecom.appnmt.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        try {
            return orderDao.countShopOrderNumByHallId(hallId);
        } catch (Exception e) {
            throw new RuntimeException("获取统计结果失败,请稍后再试!");
        }
    }

    /**
     * 在电信公司管理员页面获取每个营业厅所完成订单的数量统计
     * @return
     */
    @Override
    public List<Map<String, Object>> getHallStatisticsAtAdmPage() {
        try{
            return orderDao.countHallOrderNum();
        } catch (Exception e) {
            throw new RuntimeException("获取统计结果失败,请稍后再试");
        }
    }

    /**
     * 商店可获取自己的所有订单列表
     * @param shopId 商店id
     * @param page 默认不分页,如果有分页要求,传入页数为参数即可
     * @return
     */
    public List<Order> getListByShop(String shopId, int page) {
        try{
            return orderDao.getAllByShopId(shopId);
        } catch (Exception e) {
            throw new RuntimeException("获取订单列表失败,请稍后再试！");
        }
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
     * 电信公司可获取所有营业厅的所有订单
     *
     * @param page
     * @return
     */
    @Override
    public List<Map<String, Object>> getListByAdm(int page) {
        try{
            return orderDao.getAllByAdm();
        } catch (Exception e) {
            throw new RuntimeException("获取订单列表失败,请稍后再试!");
        }
    }

    /**
     * 用户可以获取自己的订单列表
     *
     * @param usrId 用户id
     * @param page 默认不分页,如果有分页要求,传入页数为参数即可
     * @return
     */
    public List<Map<String, Object>> getListByUser(String usrId, int page) {
        try {
            return orderDao.getAllByUsrId(usrId);
        } catch (Exception e) {
            throw new RuntimeException("获取订单列表失败,请稍后再试");
        }

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
        Order order1 = orderDao.findByOrdId(ordId);
        order1.setOrdStatus(status);
        try {
            orderDao.save(order1);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("修改订单状态失败!");
        }
    }

    /**
     * 创建一个新的订单
     *
     * @param order
     * @return
     */
    @Override
    public Order create(Order order) {
        // 设置订单时间
        if (order.getOrdTime() == null || order.getOrdTime().equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
            order.setOrdTime(date);
        }
        // 默认订单状态为 : 0 (未处理)
        order.setOrdStatus(0);
        // 设置订单id
        order.setOrdId(
                DigestUtils.md5DigestAsHex((order.getUsrId()+order.getOrdTime()).getBytes()));
        //TODO 设置订单二维码图片保存路径,暂时为NULL
        order.setOrdQrcode("NULL");
        try {
            return orderDao.save(order);
        } catch (Exception e) {
            throw new RuntimeException("订单提交失败，请稍后再试！");
        }
    }
}

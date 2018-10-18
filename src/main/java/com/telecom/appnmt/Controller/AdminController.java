package com.telecom.appnmt.Controller;

import com.telecom.appnmt.Entity.Hall;
import com.telecom.appnmt.Service.HallService;
import com.telecom.appnmt.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/adm")
public class AdminController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HallService hallService;

    /**
     * 获取所有营业厅的所有订单列表
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "/getOrderList")
    public Map<String,Object> a(HttpServletRequest req, HttpServletResponse res) {
        Map<String,Object> json = new HashMap<String, Object>();
        json.put("data",orderService.getListByAdm(-1));
        return json;
    }

    /**
     * 获取订单数量统计列表
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "/statistics")
    public Map<String,Object> b(HttpServletRequest req, HttpServletResponse res) {
        Map<String,Object> json = new HashMap<String, Object>();
        // 直接将营业厅的统计结果放入data字段
        json.put("data",orderService.getHallStatisticsAtAdmPage());
        return json;
    }

    /**
     * 电信公司可自由创建营业厅账号
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "/createHall")
    public Map<String,Object> c(HttpServletRequest req, HttpServletResponse res) {
        Map<String,Object> json = new HashMap<String, Object>();
        Hall hall = hallService.create();
        json.put("data",hall);
        json.put("info","营业厅账号创建成功！");
        json.put("status",1);
        return json;
    }

}

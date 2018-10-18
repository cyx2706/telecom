package com.telecom.appnmt.Controller;

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

    @RequestMapping(value = "/getOrderList")
    public Map<String,Object> a(HttpServletRequest req, HttpServletResponse res) {
        Map<String,Object> json = new HashMap<String, Object>();
        json.put("data",orderService.getListByAdm(-1));
        return json;
    }

    @RequestMapping(value = "/statistics")
    public Map<String,Object> b(HttpServletRequest req, HttpServletResponse res) {
        Map<String,Object> json = new HashMap<String, Object>();
        // 直接将营业厅的统计结果放入data字段
        json.put("data",orderService.getHallStatisticsAtAdmPage());
        return json;
    }

}

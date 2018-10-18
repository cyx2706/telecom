package com.telecom.appnmt.Controller;

import com.telecom.appnmt.Entity.Order;
import com.telecom.appnmt.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getOrderList")
    public Map<String,Object> getol(HttpServletRequest req, HttpServletResponse res) {
        Map json = new HashMap<String,Object>();
        String shopId = req.getSession().getAttribute("shop_id").toString();
        // 如果有传递对应的shop_id则寻找shop_id对应的订单列表
        List<Order> list = orderService.getListByShop(shopId,-1);
        json.put("data",list);
        return json;
    }

}

package com.telecom.appnmt.Controller;

import com.telecom.appnmt.Entity.Order;
import com.telecom.appnmt.Entity.Shop;
import com.telecom.appnmt.Service.OrderService;
import com.telecom.appnmt.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hall")
public class HallController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private OrderService orderService;

    /**
     * 快速创建商店
     * @return
     */
    @RequestMapping(value = "/createShop")
    public Map<String,Object> c() {
        Map res = new HashMap<String,Object>();
        String hallId = "123456";
        res.put("data",shopService.create(hallId));
        return res;
    }

    /**
     * 获取订单列表
     * @return
     */
    @RequestMapping(value = "/getOrderList")
    public Map<String,Object> a(HttpServletRequest req, HttpServletResponse res) {
        Map json = new HashMap<String,Object>();
        String shopId = req.getParameter("shop_id");
        // 如果有传递对应的shop_id则寻找shop_id对应的订单列表
        if (shopId != null && !shopId.equals("")) {
            List<Order> list = orderService.getListByShop(shopId,-1);
            json.put("data",list);
        }
        // 如果没有传递,则直接返回所有与该营业厅相关联的订单列表
        else {
            List<Map<String,Object>> list =  orderService.getListByHall(
                    req.getSession().getAttribute("hall_id").toString(),-1);
            json.put("data",list);
        }
        return json;
    }

    /**
     * (已完成)更改订单状态
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "/handleOrder")
    public Map<String,Object> d(HttpServletRequest req, HttpServletResponse res) {
        Map json = new HashMap<String,Object>();
        String ordId = req.getParameter("ord_id");
        int status = Integer.parseInt(req.getParameter("newStatus"));
        boolean result = orderService.setOrderStatus(ordId,status);
        Map resMap = new HashMap<String,Object>();
        resMap.put("msg","修改成功!");
        resMap.put("code",1);
        json.put("data",resMap);
        return json;
    }

    /**
     * 营业厅可获取下属的商店列表
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "/getShopList")
    public Map<String,Object> e(HttpServletRequest req, HttpServletResponse res){
        Map json = new HashMap<String,Object>();
        List<Shop> list = shopService.getMyShopList(req.getSession().getAttribute("hall_id").toString());
        json.put("data",list);
        return json;
    }
}

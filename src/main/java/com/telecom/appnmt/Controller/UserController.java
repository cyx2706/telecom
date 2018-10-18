package com.telecom.appnmt.Controller;

import com.telecom.appnmt.Entity.Order;
import com.telecom.appnmt.Entity.Shop;
import com.telecom.appnmt.Service.OrderService;
import com.telecom.appnmt.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Order order;

    @Autowired
    private ShopService shopService;

    /**
     * 用户提交订单Controller
     * @param req
     * @param res
     * @return
     */
    @PostMapping(value = "/submit")
    public Map<String,Object> submit(@RequestBody Map<String,Object> paraMap, HttpServletRequest req, HttpServletResponse res) {
        Map<String,Object> json = new HashMap<String, Object>();
        // 设置用户id
        order.setUsrId(req.getSession().getAttribute("usr_id").toString());
        // 设置商店id
        order.setShopId(paraMap.get("shop_id").toString());
        // 设置套餐ID
        String sch_id = (String)paraMap.get("sch_id");
        order.setSchId(Integer.parseInt(sch_id == null || sch_id.equals("") ? "1": sch_id));
        // 设置联系人称呼
        String name = paraMap.get("ord_name").toString();
        order.setOrdName(name == null || name.equals("") ?  paraMap.get("usr_name").toString() :name);
        // 设置订单电话
        order.setOrdTel(paraMap.get("ord_tel").toString());
        // 设置订单地址
        order.setOrdAddr(paraMap.get("ord_address").toString());

        json.put("data",orderService.create(order));
        json.put("info","提交成功!");
        json.put("status",1);
        return json;
    }

    /**
     * 用户可获取自己的订单列表
     * @param req
     * @param rep
     * @return
     */
    @RequestMapping(value = "/getOrderList")
    public Map<String,Object> getol(HttpServletRequest req, HttpServletResponse rep) {
        Map<String,Object> json = new HashMap<String, Object>();
        List<Map<String, Object>> list = orderService.getListByUser(req.getSession().getAttribute("usr_id").toString(),-1);
        json.put("data",list);
        return json;
    }

    @RequestMapping(value = "/getShopList")
    public Map<String,Object> getsl(HttpServletRequest req, HttpServletResponse rep) {
        Map<String,Object> json = new HashMap<String, Object>();
        // 获取所有商店列表
        List<Map<String,Object>> list = shopService.getListByPage(-1);
        json.put("data",list);
        return json;
    }
}

package com.telecom.appnmt.Controller;

import com.telecom.appnmt.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hall")
public class HallController {

    @Autowired
    private ShopService shopService;

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
    public Map<String,Object> a() {
        Map res = new HashMap<String,Object>();
        return res;
    }
}

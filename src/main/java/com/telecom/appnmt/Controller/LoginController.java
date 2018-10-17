package com.telecom.appnmt.Controller;

import com.telecom.appnmt.Entity.Admin;
import com.telecom.appnmt.Entity.Hall;
import com.telecom.appnmt.Entity.Shop;
import com.telecom.appnmt.Entity.User;
import com.telecom.appnmt.Service.AdminService;
import com.telecom.appnmt.Service.HallService;
import com.telecom.appnmt.Service.ShopService;
import com.telecom.appnmt.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private HallService hallService;

    @Autowired
    private ShopService shopService;


    @Autowired
    private AdminService adminService;

    /**
     * 用户登录接口
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "/user")
    public Map<String,Object> user(HttpServletRequest req, HttpServletResponse res) {
        Map<String,Object> json = new HashMap<String, Object>();
        String tel = req.getParameter("usr_tel");
        String openId = req.getParameter("open_id");
        User user = userService.login(tel,openId);
        // 登录失败发出提示
        if (user == null) {
            throw new RuntimeException("登录失败");
        }
        // 登录成功,保存ID到session
        else {
            req.getSession().setAttribute("usr_id",user.getUsrId());
        }
        return json;
    }

    /**
     * 营业厅登录接口
     * 使用账号密码登录
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "/hall")
    public Map<String,Object> hall(HttpServletRequest req, HttpServletResponse res) {
        Map<String,Object> json = new HashMap<String, Object>();
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        Hall hall = hallService.login(account,password);
        // 登录失败发出提示
        if (hall == null) {
            throw new RuntimeException("登录失败");
        }
        // 登录成功,保存ID到session
        else {
            req.getSession().setAttribute("hall_id",hall.getHallId());
        }
        return json;
    }

    /**
     * 营业厅登录接口
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "/shop")
    public Map<String,Object> shop(HttpServletRequest req, HttpServletResponse res) {
        Map<String,Object> json = new HashMap<String, Object>();
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        Shop shop = shopService.login(account,password);
        // 登录失败发出提示
        if (shop == null) {
            throw new RuntimeException("登录失败");
        }
        // 登录成功,保存ID到session
        else {
            req.getSession().setAttribute("shop_id",shop.getShopId());
        }
        return json;
    }

    /**
     * 营业厅登录接口
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "/adm")
    public Map<String,Object> adm(HttpServletRequest req, HttpServletResponse res) {
        Map<String,Object> json = new HashMap<String, Object>();
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        Admin adm = adminService.login(account,password);
        // 登录失败发出提示
        if (adm == null) {
            throw new RuntimeException("登录失败");
        }
        // 登录成功,保存ID到session
        else {
            req.getSession().setAttribute("adm_id",adm.getAdmId());
        }
        return json;
    }

}

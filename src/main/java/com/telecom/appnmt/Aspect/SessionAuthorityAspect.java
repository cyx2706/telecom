package com.telecom.appnmt.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Session权限验证切面类
 */
@Aspect
@Component
public class SessionAuthorityAspect {


    /**
     * 切入点为所有/stu路径下的控制器
     */
    @Pointcut("execution(public * com.telecom.appnmt.Controller.UserController.*(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse))") // Pointcut注释必须关联空方法
    public void UserAccessOperation() {}

    /**
     * 普通用户请求在操作/user路径下的api时必须先登录并在服务器中保存session
     * @param req
     * @param res
     * @throws RuntimeException
     */
    @Before(value = "UserAccessOperation() && args(req,res)",argNames = "req,res")
    public void beforeUserAccessOperation(HttpServletRequest req, HttpServletResponse res) throws RuntimeException {
        if (req.getSession().getAttribute("usr_id") == null) {
            throw new RuntimeException("您无权限操作,请先登录用户账号!");
        }
    }

    /**
     * 切入点为所有/shop路径下的控制器
     */
    @Pointcut("execution(public * com.telecom.appnmt.Controller.ShopController.*(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse))")
    public void ShopAccessOperation() {}


    /**
     * 普通用户请求在操作/shop路径下的api时必须先登录并在服务器中保存session
     * @param req
     * @param res
     * @throws RuntimeException
     */
    @Before(value = "ShopAccessOperation() && args(req,res)",argNames = "req,res")
    public void beforeShopAccessOperation(HttpServletRequest req, HttpServletResponse res) throws RuntimeException {
        if (req.getSession().getAttribute("shop_id") == null) {
            throw new RuntimeException("您无权限操作,请先登录商店账号!");
        }
    }

    /**
     * 切入点为所有/hall路径下的控制器
     */
    @Pointcut("execution(public * com.telecom.appnmt.Controller.HallController.*(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse))")
    public void HallAccessOperation() {}


    /**
     * 普通用户请求在操作/hall路径下的api时必须先登录并在服务器中保存session
     * @param req
     * @param res
     * @throws RuntimeException
     */
    @Before(value = "HallAccessOperation() && args(req,res)",argNames = "req,res")
    public void beforeHallAccessOperation(HttpServletRequest req, HttpServletResponse res) throws RuntimeException {
        if (req.getSession().getAttribute("hall_id") == null) {
            throw new RuntimeException("您无权限操作,请先登录营业厅账号!");
        }
    }


    /**
     * 切入点为所有/hall路径下的控制器
     */
    @Pointcut("execution(public * com.telecom.appnmt.Controller.AdminController.*(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse))")
    public void AdminAccessOperation() {}


    /**
     * 普通用户请求在操作/hall路径下的api时必须先登录并在服务器中保存session
     * @param req
     * @param res
     * @throws RuntimeException
     */
    @Before(value = "AdminAccessOperation() && args(req,res)",argNames = "req,res")
    public void beforeAdminAccessOperation(HttpServletRequest req, HttpServletResponse res) throws RuntimeException {
        if (req.getSession().getAttribute("adm_id") == null) {
            throw new RuntimeException("您无权限操作,请先登录电信公司管理员账号!");
        }
    }


}

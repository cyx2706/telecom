package com.telecom.appnmt.Service;

import com.telecom.appnmt.Entity.Admin;

public interface AdminService {

    /**
     * 创建一个管理员账号
     * @param account
     * @param password
     * @return
     */
    public Admin create(String account,String password);

    /**
     * 根据提交的账号和密码寻找是否有存在的管理员账号
     * @param account
     * @param password
     * @return
     */
    public Admin find(String account,String password);

    /**
     * 登录接口,账号及密码登录
     * @param account
     * @param password
     * @return Admin|null
     */
    public Admin login(String account,String password);
}

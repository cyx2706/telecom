package com.telecom.appnmt.Service;

import com.telecom.appnmt.Entity.User;

public interface UserService {
    /**
     * 根据手机号或微信号验证
     * @param tel
     * @param openId
     * @return
     */
    public User login(String tel, String openId);

    /**
     * 创建一个新的用户账号
     * @param tel
     * @param openId
     * @return
     */
    public User create(String tel, String openId);
}

package com.telecom.appnmt.Dao;

import com.telecom.appnmt.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User实体的Dao层
 */
public interface UserDao extends JpaRepository<User, String>{

    /**
     * 用户使用手机号登录账号
     * @param tel
     * @return
     */
    public User findByUsrTel(String tel);

    /**
     * 用户使用微信号登录账号
     * @param openId
     * @return
     */
    public User findByUsrOpenId(String openId);
}

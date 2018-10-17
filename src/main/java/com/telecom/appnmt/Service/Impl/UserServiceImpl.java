package com.telecom.appnmt.Service.Impl;

import com.telecom.appnmt.Dao.UserDao;
import com.telecom.appnmt.Entity.User;
import com.telecom.appnmt.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private User user;

    /**
     * 根据手机号或微信号验证
     * @param tel
     * @param openId
     * @return
     */
    @Override
    public User login(String tel, String openId) {
        User user = null;
        if (tel != null && !"".equals(tel)) {
            user = userDao.findByUsrTel(tel);
        }
        else if(openId != null && !"".equals(openId)) {
            user = userDao.findByUsrOpenId(openId);
        }
        if (user == null) {
            user = this.create(tel,openId);
        }
        return user;
    }

    /**
     * 创建一个新的用户账号
     * @param tel
     * @param openId
     * @return
     */
    @Override
    public User create(String tel, String openId) {
        // 用户id由注册时的openid及联系电话组成
        user.setUsrId(DigestUtils.md5DigestAsHex(
                (tel + openId).getBytes()));
        user.setUsrOpenId(openId);
        user.setUsrTel(tel);
        User res = null;
        try {
            res = userDao.save(user);
        } catch (Exception e) {
            throw new RuntimeException("系统出现错误,请尝试重新登录");
        }
        return res;
    }


}

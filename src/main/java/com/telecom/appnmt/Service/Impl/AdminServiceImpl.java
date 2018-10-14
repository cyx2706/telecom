package com.telecom.appnmt.Service.Impl;

import com.telecom.appnmt.Dao.AdminDao;
import com.telecom.appnmt.Entity.Admin;
import com.telecom.appnmt.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private Admin admin;

    @Autowired
    private AdminDao adminDao;
    /**
     * 创建一个管理员账号
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public Admin create(String account, String password) {
        admin.setAdmAccount(account);
        admin.setAdmId(DigestUtils.md5DigestAsHex(admin.getAdmAccount().getBytes()));
        admin.setAdmPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        return adminDao.save(admin);
    }

    /**
     * 根据提交的账号和密码寻找是否有存在的管理员账号
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public Admin find(String account, String password) {
        return adminDao.findByAdmAccountAndAdmPassword(
                account,
                DigestUtils.md5DigestAsHex(password.getBytes()));
    }
}

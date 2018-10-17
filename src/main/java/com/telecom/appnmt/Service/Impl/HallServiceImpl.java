package com.telecom.appnmt.Service.Impl;

import com.telecom.appnmt.Dao.HallDao;
import com.telecom.appnmt.Entity.Hall;
import com.telecom.appnmt.Service.HallService;
import com.telecom.appnmt.Utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallDao hallDao;

    @Autowired
    private Hall hall;

    /**
     * 创建一个新的营业厅到数据库
     * @return
     */
    public Hall create() {
        // account 默认情况下就是 hall_数字 表示第几个hall
        hall.setHallAccount("hall_"+(hallDao.count()+1));
        // tel 电话默认是13XXXXXXXXX(后面9位随机数)
        hall.setHallTel("13"+RandomUtil.getNBitRandomDigit(9));
        // 主键id,以联系方式+登录账号的md5格式保存
        hall.setHallId(
                DigestUtils.md5DigestAsHex((hall.getHallAccount()+hall.getHallTel()).getBytes()));
        // 默认密码abc123
        hall.setHallPassword(
                DigestUtils.md5DigestAsHex("abc123".getBytes()));
        // 默认与account一致
        hall.setHallName(hall.getHallAccount());
        try {
            // 错误调试
            // int i = 1/0;
            return hallDao.save(hall);
        } catch (Exception e) {
            throw new RuntimeException("系统在创建账号时发生了错误,请稍后再试!");
        }
    }

    /**
     * 默认不分页,如要分页 5个/页
     * @param page
     * @return
     */
    public List<Hall> getListByPage(int page) {
        if (page < 0) {
            return hallDao.findAll();
        }
        Pageable pageable = new PageRequest(page, 5, Sort.Direction.ASC, "hallAccount");
        try {
            Page<Hall> halls= hallDao.findAll(pageable);
            return halls.getContent();
        } catch (Exception e) {
            throw new RuntimeException("系统在获取商店列表时发生了错误,请稍后再试!");
        }
    }

    /**
     * 营业厅必须使用账号及密码登录
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public Hall login(String account, String password) {
        return hallDao.findByHallAccountAndHallPassword(
                account,password);
    }
}

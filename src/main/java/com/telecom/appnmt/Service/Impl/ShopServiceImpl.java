package com.telecom.appnmt.Service.Impl;

import com.telecom.appnmt.Dao.ShopDao;
import com.telecom.appnmt.Entity.Shop;
import com.telecom.appnmt.Service.ShopService;
import com.telecom.appnmt.Utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private Shop shop;

    /**
     * 创建一个新的营业厅到数据库
     * @return
     */
    @Override
    public Shop create(String Hallid) {
        // 记录创建该商店的营业厅id 方便以后查询
        shop.setHallId(Hallid);
        // account 默认情况下就是 shop_数字 表示第几个shop
        shop.setShopAccount("shop_"+(shopDao.count()+1));
        // tel 电话默认是13XXXXXXXXX(后面9位随机数)
        shop.setShopTel("13"+RandomUtil.getNBitRandomDigit(9));
        // 主键id,以联系方式+登录账号的md5格式保存
        shop.setShopId(
                DigestUtils.md5DigestAsHex((shop.getShopAccount()+shop.getShopTel()).getBytes()));
        // 默认密码abc123
        shop.setShopPassword(
                DigestUtils.md5DigestAsHex("abc123".getBytes()));
        // 默认与account一致
        shop.setShopName(shop.getShopAccount());

        // 暂时不绑定生成之后再绑定
        shop.setShopOpenId("NULL");
        shop.setShopQrcode("NULL");
        try {
            // 错误调试
            // int i = 1/0;
            return shopDao.save(shop);
        } catch (Exception e) {
            throw new RuntimeException("系统在创建账号时发生了错误,请稍后再试!");
        }
    }

    /**
     * 默认不分页,如要分页 5个/页
     * @param page
     * @return
     */
    public List<Shop> getListByPage(int page) {
        if (page < 0) {
            return shopDao.findAll();
        }
        Pageable pageable = new PageRequest(page, 5, Sort.Direction.ASC, "shopAccount");
        try {
            Page<Shop> shops= shopDao.findAll(pageable);
            return shops.getContent();
        } catch (Exception e) {
            throw new RuntimeException("系统在获取商店列表时发生了错误,请稍后再试!");
        }
    }
}

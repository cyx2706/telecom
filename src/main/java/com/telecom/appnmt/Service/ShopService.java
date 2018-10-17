package com.telecom.appnmt.Service;

import com.telecom.appnmt.Entity.Shop;

import java.util.List;

public interface ShopService {

    /**
     * 创建一个新的营业厅到数据库
     * @return
     */
    public Shop create(String HallId);

    /**
     * 获取营业厅列表
     * @param page
     * @return
     */
    public List<Shop> getListByPage(int page);

    /**
     * 登录接口,根据账号及密码登录
     * @param account
     * @param password
     * @return
     */
    public Shop login(String account,String password);

    /**
     * 获取营业厅管理的商店
     * @param HallId
     * @return
     */
    public List<Shop> getMyShopList(String HallId);
}

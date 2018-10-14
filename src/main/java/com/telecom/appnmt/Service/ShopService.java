package com.telecom.appnmt.Service;

import com.telecom.appnmt.Entity.Shop;

import java.util.List;

public interface ShopService {

    /**
     * 创建一个新的营业厅到数据库
     * @return
     */
    public Shop create(String Hallid);

    /**
     * 获取营业厅列表
     * @param page
     * @return
     */
    public List<Shop> getListByPage(int page);
}

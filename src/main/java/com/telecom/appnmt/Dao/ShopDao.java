package com.telecom.appnmt.Dao;

import com.telecom.appnmt.Entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ShopDao extends JpaRepository<Shop, String>,JpaSpecificationExecutor<Shop> {

    /**
     * 根据商店id查找商店
     * @param id
     * @return
     */
    public Shop findByShopId(String id);

    /**
     * 根据商店账号及密码寻找商店,用于登录
     * @param account
     * @param password
     * @return
     */
    public Shop findByShopAccountAndShopPassword(String account,String password);

    /**
     * 根据营业厅
     * @param hallId
     * @return
     */
    public List<Shop> findAllByHallId(String hallId);
}

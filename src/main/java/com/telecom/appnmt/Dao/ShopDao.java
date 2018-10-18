package com.telecom.appnmt.Dao;

import com.telecom.appnmt.Entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

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
     * 根据营业厅Id获取其下属的商店
     * @param hallId
     * @return
     */
    @Query(value = "SELECT * FROM shop WHERE shop.hall_id=?1",nativeQuery = true)
    public List<Map<String,Object>> findAllByHallId(String hallId);

    /**
     * 一次性获取所有商店的列表
     * @return
     */
    @Query(value = "SELECT * FROM shop",nativeQuery = true)
    public List<Map<String,Object>> getAll();
}

package com.telecom.appnmt.Dao;

import com.telecom.appnmt.Entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ShopDao extends JpaRepository<Shop, String>,JpaSpecificationExecutor<Shop> {

    public List<Shop> findAllByShopId(String id);

    public Shop findByShopId(String id);

}

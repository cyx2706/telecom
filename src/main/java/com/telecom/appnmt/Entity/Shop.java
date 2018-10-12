package com.telecom.appnmt.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 营业厅对象
 */
@Table(name = "shop")
@Entity
@Component
public class Shop {
    @Id
    private String shopId;

    @Column(nullable = false, unique = true)
    private String shopAccount;

    @Column(nullable = false)
    private String shopPassword;

    @Column(nullable = true, unique = true)
    private String shopOpenId;

    @Column(nullable = false, unique = true)
    private String shopName;

    @Column(nullable = false, unique = true)
    private String shopTel;

    @Column(nullable = false,columnDefinition = "tinyint(2) DEFAULT 1")
    private int shopStatus = 1;

    @Column(nullable = true, unique = true)
    private String shopQrcode;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopAccount() {
        return shopAccount;
    }

    public void setShopAccount(String shopAccount) {
        this.shopAccount = shopAccount;
    }

    public String getShopPassword() {
        return shopPassword;
    }

    public void setShopPassword(String shopPassword) {
        this.shopPassword = shopPassword;
    }

    public String getShopOpenId() {
        return shopOpenId;
    }

    public void setShopOpenId(String shopOpenId) {
        this.shopOpenId = shopOpenId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopTel() {
        return shopTel;
    }

    public void setShopTel(String shopTel) {
        this.shopTel = shopTel;
    }

    public int getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(int shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getShopQrcode() {
        return shopQrcode;
    }

    public void setShopQrcode(String shopQrcode) {
        this.shopQrcode = shopQrcode;
    }
}

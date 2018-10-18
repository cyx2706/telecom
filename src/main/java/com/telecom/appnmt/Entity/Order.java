package com.telecom.appnmt.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 2018/10/13 00:12:00修改
 * 订单对象
 */
@Table(name = "`order`")
@Entity
@Component
public class Order {
    @Id
    private String ordId;

    @Column(nullable = false)
    private String usrId;

    @Column(nullable = false)
    private String shopId;

    @Column(nullable = false)
    private int schId;

    @Column(nullable = false)
    private String ordName;

    @Column(nullable = false)
    private String ordTel;

    @Column(nullable = false)
    private String ordAddr;

    @Column(nullable = false)
    private String ordTime;

    /**
     * 订单的二维码图片保存地址,默认可以为空
     */
    @Column(nullable = true)
    private String ordQrcode;

    /**
     * 订单创建是,默认状态是0 未支付
     */
    @Column(nullable = false,columnDefinition = "tinyint(2) DEFAULT 0")
    private int ordStatus = 0;

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public int getSchId() {
        return schId;
    }

    public void setSchId(int schId) {
        this.schId = schId;
    }

    public String getOrdName() {
        return ordName;
    }

    public void setOrdName(String ordName) {
        this.ordName = ordName;
    }

    public String getOrdTel() {
        return ordTel;
    }

    public void setOrdTel(String ordTel) {
        this.ordTel = ordTel;
    }

    public String getOrdAddr() {
        return ordAddr;
    }

    public void setOrdAddr(String ordAddr) {
        this.ordAddr = ordAddr;
    }

    public String getOrdTime() {
        return ordTime;
    }

    public void setOrdTime(String ordTime) {
        this.ordTime = ordTime;
    }

    public int getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(int ordStatus) {
        this.ordStatus = ordStatus;
    }

    public String getOrdQrcode() {
        return ordQrcode;
    }

    public void setOrdQrcode(String ordQrcode) {
        this.ordQrcode = ordQrcode;
    }
}

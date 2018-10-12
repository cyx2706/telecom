package com.telecom.appnmt.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 2018/10/13 00:12:00修改
 * 订单对象
 */
@Table(name = "order")
@Entity
@Component
public class Order {
    @Id
    private String ordId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String shopId;

    @Column(nullable = false)
    private int schid;

    @Column(nullable = false)
    private String ordTel;

    @Column(nullable = false)
    private String ordAddr;

    @CreatedDate
    @Column(nullable = false)
    private Date ordTime;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public int getSchid() {
        return schid;
    }

    public void setSchid(int schid) {
        this.schid = schid;
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

    public Date getOrdTime() {
        return ordTime;
    }

    public void setOrdTime(Date ordTime) {
        this.ordTime = ordTime;
    }

    public int getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(int ordStatus) {
        this.ordStatus = ordStatus;
    }
}

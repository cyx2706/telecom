package com.telecom.appnmt.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 营业厅对象
 */
@Table(name = "order")
@Entity
@Component
public class Order {
    @Id
    private String orderId;

    @Column(nullable = false, unique = true)
    private String orderName;

    @Column(nullable = false, unique = true)
    private String orderTel;

    @Column(nullable = false,columnDefinition = "tinyint(2) DEFAULT 1")
    private int orderStatus = 1;
}

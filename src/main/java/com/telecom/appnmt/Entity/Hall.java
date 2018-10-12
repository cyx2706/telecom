package com.telecom.appnmt.Entity;


import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 营业厅对象
 */
@Table(name = "hall")
@Entity
@Component
public class Hall implements Serializable {

    @Id
    // @GeneratedValue 非自增长值
    private String hallId;

    @Column(nullable = false, unique = true)
    private String hallAccount;

    @Column(nullable = false)
    private String hallPassword;

    @Column(nullable = false, unique = true)
    private String hallName;

    @Column(nullable = false, unique = true)
    private String hallTel;

    @Column(nullable = false,columnDefinition = "tinyint(2) DEFAULT 1")
    private int hallStatus = 1;

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getHallAccount() {
        return hallAccount;
    }

    public void setHallAccount(String hallAccount) {
        this.hallAccount = hallAccount;
    }

    public String getHallPassword() {
        return hallPassword;
    }

    public void setHallPassword(String hallPassword) {
        this.hallPassword = hallPassword;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getHallTel() {
        return hallTel;
    }

    public void setHallTel(String hallTel) {
        this.hallTel = hallTel;
    }

    public int getHallStatus() {
        return hallStatus;
    }

    public void setHallStatus(int hallStatus) {
        this.hallStatus = hallStatus;
    }
}

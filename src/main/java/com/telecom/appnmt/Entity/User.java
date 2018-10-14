package com.telecom.appnmt.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
@Entity
@Component
public class User {
    @Id
    private String usrId;

    @Column(nullable = true)
    private String usrOpenId;

    @Column(nullable = false, unique = true)
    private String usrTel;

    @Column(nullable = false,columnDefinition = "tinyint(2) DEFAULT 1")
    private int usrStatus = 1;

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrOpenId() {
        return usrOpenId;
    }

    public void setUsrOpenId(String usrOpenId) {
        this.usrOpenId = usrOpenId;
    }

    public String getUsrTel() {
        return usrTel;
    }

    public void setUsrTel(String usrTel) {
        this.usrTel = usrTel;
    }

    public int getUsrStatus() {
        return usrStatus;
    }

    public void setUsrStatus(int usrStatus) {
        this.usrStatus = usrStatus;
    }
}

package com.telecom.appnmt.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "admin")
@Entity
@Component
public class Admin {
    @Id
    private String admId;

    @Column(nullable = false, unique = true)
    private String admAccount;

    @Column(nullable = false)
    private String admPassword;

    @Column(nullable = false,columnDefinition = "tinyint(2) DEFAULT 1")
    private int admStatus = 1;

    public String getAdmId() {
        return admId;
    }

    public void setAdmId(String admId) {
        this.admId = admId;
    }

    public String getAdmAccount() {
        return admAccount;
    }

    public void setAdmAccount(String admAccount) {
        this.admAccount = admAccount;
    }

    public String getAdmPassword() {
        return admPassword;
    }

    public void setAdmPassword(String admPassword) {
        this.admPassword = admPassword;
    }

    public int getAdmStatus() {
        return admStatus;
    }

    public void setAdmStatus(int admStatus) {
        this.admStatus = admStatus;
    }
}

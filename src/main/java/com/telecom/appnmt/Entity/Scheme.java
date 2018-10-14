package com.telecom.appnmt.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Table(name = "`scheme`")
@Entity
@Component
public class Scheme {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer schId;

    @Column(nullable = false)
    private String schContent;

    @Column(nullable = false)
    private int schPrice;

    @Column(nullable = false,columnDefinition = "tinyint(2) DEFAULT 1")
    private int schStatus = 1;

    public Integer getSchId() {
        return schId;
    }

    public void setSchId(Integer schId) {
        this.schId = schId;
    }

    public String getSchContent() {
        return schContent;
    }

    public void setSchContent(String schContent) {
        this.schContent = schContent;
    }

    public int getSchPrice() {
        return schPrice;
    }

    public void setSchPrice(int schPrice) {
        this.schPrice = schPrice;
    }

    public int getSchStatus() {
        return schStatus;
    }

    public void setSchStatus(int schStatus) {
        this.schStatus = schStatus;
    }
}

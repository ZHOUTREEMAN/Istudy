package com.xmu.istudy.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2020-07-08 15:56:21
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = -53496881372260755L;
    
    private Long id;
    
    private Long adminNo;
    
    private String adminName;
    
    private String adminPassword;
    
    private String adminPhone;
    
    private Object adminGender;
    
    private String adminEmail;
    
    private Object status;
    
    private Date lastUpdateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Long adminNo) {
        this.adminNo = adminNo;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public Object getAdminGender() {
        return adminGender;
    }

    public void setAdminGender(Object adminGender) {
        this.adminGender = adminGender;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

}
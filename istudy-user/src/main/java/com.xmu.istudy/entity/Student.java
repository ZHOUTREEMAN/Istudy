package com.xmu.istudy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2020-07-08 15:53:03
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -58289598020420219L;
    
    private Long id;
    
    private Long studentNo;
    
    private String studentName;
    
    private String studentPassword;
    
    private String studentPhone;
    
    private Object studentGender;
    
    private String studentEmail;
    
    private Object status;
    
    private Date lastUpdateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Long studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public Object getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(Object studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
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
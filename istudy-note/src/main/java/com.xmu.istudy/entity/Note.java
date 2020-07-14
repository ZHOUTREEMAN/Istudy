package com.xmu.istudy.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 公告表(Note)实体类
 *
 * @author makejava
 * @since 2020-07-13 14:59:10
 */
public class Note implements Serializable {
    private static final long serialVersionUID = 142956199721523848L;
    
    private Long id;
    
    private String tag;
    
    private String titile;
    
    private Object status;
    
    private String content;
    
    private Date lastUpdateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

}
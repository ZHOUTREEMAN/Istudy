package com.xmu.istudy.entity;

import java.io.Serializable;

/**
 * (Room)实体类
 *
 * @author makejava
 * @since 2020-07-13 09:29:26
 */
public class Room implements Serializable {
    private static final long serialVersionUID = 362395493819989671L;

    private Long id;

    private Object type;
    /*1-可用；2-关闭*/
    private int status;

    private Long teacherId;

    private String address;

    private Long totalSeatNum;

    private Long availableSeatNum;

    private Long occupiedSeatNum;

    private Object openTime;

    private Object closeTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTotalSeatNum() {
        return totalSeatNum;
    }

    public void setTotalSeatNum(Long totalSeatNum) {
        this.totalSeatNum = totalSeatNum;
    }

    public Long getAvailableSeatNum() {
        return availableSeatNum;
    }

    public void setAvailableSeatNum(Long availableSeatNum) {
        this.availableSeatNum = availableSeatNum;
    }

    public Long getOccupiedSeatNum() {
        return occupiedSeatNum;
    }

    public void setOccupiedSeatNum(Long occupiedSeatNum) {
        this.occupiedSeatNum = occupiedSeatNum;
    }

    public Object getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Object openTime) {
        this.openTime = openTime;
    }

    public Object getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Object closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type=" + type +
                ", status=" + status +
                ", teacherId=" + teacherId +
                ", address='" + address + '\'' +
                ", totalSeatNum=" + totalSeatNum +
                ", availableSeatNum=" + availableSeatNum +
                ", occupiedSeatNum=" + occupiedSeatNum +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                '}';
    }
}
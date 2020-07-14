package com.xmu.istudy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Reservation)实体类
 *
 * @author makejava
 * @since 2020-07-14 02:11:35
 */
public class Reservation implements Serializable {
    private static final long serialVersionUID = -30029355847074344L;

    private Long id;

    private Long roomId;

    private Long studentId;

    private Long seatId;

    private Date reserveStartTime;

    private Date reserveEndTime;

    private Date lastUpdateTime;

    /*1-可用但未签到，2-过期未签到，3-已签到且未过期，4-已签到且已过期（预约时间已经结束）,5-已取消*/
    private int status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public Date getReserveStartTime() {
        return reserveStartTime;
    }

    public void setReserveStartTime(Date reserveStartTime) {
        this.reserveStartTime = reserveStartTime;
    }

    public Date getReserveEndTime() {
        return reserveEndTime;
    }

    public void setReserveEndTime(Date reserveEndTime) {
        this.reserveEndTime = reserveEndTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
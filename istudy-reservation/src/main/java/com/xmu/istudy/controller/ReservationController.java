package com.xmu.istudy.controller;

import com.xmu.istudy.entity.Reservation;
import com.xmu.istudy.service.ReservationService;
import com.xmu.istudy.util.JwtUtils;
import com.xmu.istudy.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * (Reservation)表控制层
 *
 * @author makejava
 * @since 2020-07-15 03:33:41
 */
@RestController
@RequestMapping("reservation")
public class ReservationController {
    /**
     * 服务对象
     */
    @Resource
    private ReservationService reservationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    public Reservation selectOne(@PathVariable Long id) {
        return this.reservationService.queryById(id);
    }

    /**
     *新建预约
     * @Param request
     * @Param reservation
     * @Return
     */
    @PostMapping("")
    public Object newReservation(HttpServletRequest request, @RequestBody Reservation reservation){
        if(JwtUtils.ifauthz(request,"admin")||JwtUtils.ifauthz(request,"teacher")||JwtUtils.ifauthz(request,"student"))
        {
            /*//该房间是否可用
            Room targetRoom = roomFeign.getRoomById(reservation.getRoomId());
            if (targetRoom==null||targetRoom.getStatus()!=1){
                return ResponseUtil.badArgument();
            }
            //判断该座位是否可用
            Seat targetSeat = roomFeign.selectOne(reservation.getSeatId());
            if (targetSeat==null||targetSeat.getStatus()!=1){
                return ResponseUtil.badArgument();
            }*/

            Reservation result=reservationService.insert(reservation);
            if(null==result) {
                return ResponseUtil.fail();
            } else {
                return ResponseUtil.ok(result);
            }
        }
        else
        {
            return ResponseUtil.unauthz();
        }
    }

    /**
     * 取消预约---将预约信息的状态改为已取消！
     * @Param request
     * @Param id
     * @Return
     */

    @PutMapping("/cancel/{id}")
    public Object deleteReservation(HttpServletRequest request,@PathVariable Long id){
        /*判断该id对应的reservation是否存在*/
        Reservation targetReservation = reservationService.queryById(id);
        /*只能对未过期且未签到的预约信息进行取消操作*/
        if(targetReservation.getStatus()!=1){
            return ResponseUtil.unauthz();
        }
        /*判断该id对应的reservation的userID是否和request中存在的userId相同*/
        //else if(targetReservation.getStudentId()!=request.getHeader())

        Reservation example = new Reservation();
        example.setStatus(5);

        return ResponseUtil.ok(reservationService.update(example));
    }

    /**
     * 查找所有reservation记录
     * @Param page
     * @Param limit
     * @return
     */
    @GetMapping("/admin/list")
    public Object queryAllReservations(HttpServletRequest request,
                                       @RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "10") Integer limit){
        if(JwtUtils.ifauthz(request,"admin")) {
            return ResponseUtil.ok(reservationService.queryAllByLimit(page, limit));
        }
        else{
            return ResponseUtil.unauthz();
        }
    }

    /**
     * 查找某用户的预约记录
     * @param studentId
     */
    @GetMapping("/{studentId}")
    public Object queryReservationByUserId(HttpServletRequest request,@PathVariable Long studentId){
        /*TODO 从token中获取userId*/

        Reservation example = new Reservation();
        example.setStudentId(studentId);
        return ResponseUtil.ok(reservationService.queryAll(example));
    }
    /**
     *按不同状态查找预约信息
     * @Param
     */
    @GetMapping("/admin/status")
    public Object getReservationByStatus(HttpServletRequest request,@RequestParam Integer statusCode){
        if(JwtUtils.ifauthz(request,"admin"))
        {
            Reservation example = new Reservation();
            example.setStatus(statusCode);
            return ResponseUtil.ok(reservationService.queryAll(example));
        }
        else{
            return ResponseUtil.unauthz();
        }
    }

    /**
     * 修改预约信息
     * @Param reservation
     * @param id
     */
    @PutMapping("/{id}")
    public Object updateReservation(@PathVariable Long id, Reservation example, HttpServletRequest request){
        /*判断是否存在该id*/
        if(reservationService.queryById(id)== null || reservationService.queryById(id).getStatus()!=1
                || reservationService.queryById(id).getStatus()!=3){
            return ResponseUtil.badArgument();
        }
        else{
            example.setLastUpdateTime(new Date());
            return ResponseUtil.ok(reservationService.update(example));
        }
    }
}
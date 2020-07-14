package com.xmu.istudy.controller;

import com.xmu.istudy.entity.Room;
import com.xmu.istudy.service.RoomService;
import com.xmu.istudy.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * (Room)表控制层
 *
 * @author makejava
 * @since 2020-07-13 09:29:27
 */
@RestController
@RequestMapping("/roomService/room")
public class RoomController {
    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
    /**
     * 服务对象
     */
    @Autowired
    private RoomService roomService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Room selectOne(Long id) {
        return this.roomService.queryById(id);
    }


    /**
     * 获取自习室列表
     * @Param page
     * @param limit
     */
    @GetMapping("/roomList")
    public Object roomList(HttpServletRequest request,
                           @RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "5") Integer limit){
        List<Room> roomList = roomService.queryAllByLimit(page,limit);
        if(roomList.isEmpty()){
            return ResponseUtil.getFail();
        }else {
            return ResponseUtil.ok(roomList);
        }
    }

    @GetMapping("/{roomId}")
    public Object getRoomById(@PathVariable Long roomId){
        if(roomId<0){
            logger.debug("room id 参数不合法");
            return ResponseUtil.illegalParameter();
        }
        Room room = roomService.queryById(roomId);
        if (room == null) {
            return ResponseUtil.getFail();
        }
        else{
            return ResponseUtil.ok(room);
        }
    }

    @GetMapping("/open")
    public Object getOpenRooms(Room room){
        /*将room状态设为开放*/
        room.setStatus(1);
        List<Room> openRooms = roomService.queryAll(room);
        return ResponseUtil.ok(openRooms);
    }

    @GetMapping("/close")
    public Object getCloseRooms(Room room){
        room.setStatus(0);
        List<Room> closedRooms = roomService.queryAll(room);
        return ResponseUtil.ok(closedRooms);
    }

    @PostMapping("")
    public Object addRoom(@RequestBody Room room){
            Room newRoom = roomService.insert(room);
            if(newRoom == null){
                logger.debug("创建自习室失败");
                return ResponseUtil.addFail();
            }
            else{
                return ResponseUtil.ok(newRoom);
            }
        }
     @DeleteMapping("/{roomId}")
    public Object deleteRoom(@PathVariable Long roomId){
        if (roomId<0){
            logger.debug("参数不合法");
            return ResponseUtil.illegalParameter();
        }
        if (roomService.deleteById(roomId)){
            return ResponseUtil.ok();
        }
        else{
            logger.debug("删除自习室失败");
            return ResponseUtil.deleteFail();
        }
     }

     @PutMapping("/{roomId}")
    public Object updateRoom(@PathVariable Long roomId,@RequestBody Room room){
        if(roomId<0){
            logger.debug("参数不合法");
            return ResponseUtil.illegalParameter();
        }
        if (room==null){
            logger.debug("参数不合法");
            return ResponseUtil.illegalParameter();
        }
        Room updatedRoom = roomService.update(roomId,room);
        if (updatedRoom== null){
            logger.debug("修改自习室失败");
            return ResponseUtil.updateFail();
        }
        else {
            return ResponseUtil.ok(updatedRoom);
        }
     }
    }

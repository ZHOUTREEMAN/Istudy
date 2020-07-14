package com.xmu.istudy.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xmu.istudy.dao.SeatDao;
import com.xmu.istudy.entity.Seat;
import com.xmu.istudy.service.SeatService;
import org.springframework.stereotype.Service;

/**
 * (Seat)表服务实现类
 *
 * @author Chaney
 */
@Service("seatService")
public class SeatServiceImpl extends ServiceImpl<SeatDao, Seat> implements SeatService {

}
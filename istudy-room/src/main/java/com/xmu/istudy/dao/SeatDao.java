package com.xmu.istudy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xmu.istudy.entity.Seat;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Seat)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-14 04:01:26
 */
@Mapper
public interface SeatDao extends BaseMapper<Seat> {

}
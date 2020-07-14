package com.xmu.istudy.dao;

import com.xmu.istudy.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Reservation)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-14 02:11:35
 */
@Mapper
public interface ReservationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Reservation queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Reservation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param reservation 实例对象
     * @return 对象列表
     */
    List<Reservation> queryAll(Reservation reservation);

    /**
     * 新增数据
     *
     * @param reservation 实例对象
     * @return 影响行数
     */
    int insert(Reservation reservation);

    /**
     * 修改数据
     *
     * @param reservation 实例对象
     * @return 影响行数
     */
    int update(Reservation reservation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}
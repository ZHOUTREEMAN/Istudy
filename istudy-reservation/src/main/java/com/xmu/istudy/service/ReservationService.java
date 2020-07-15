package com.xmu.istudy.service;

import com.xmu.istudy.entity.Reservation;

import java.util.List;

/**
 * (Reservation)表服务接口
 *
 * @author makejava
 * @since 2020-07-15 03:33:41
 */
public interface ReservationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Reservation queryById(Long id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param reservation 实例对象
     * @return 对象列表
     */
    List<Reservation> queryAll(Reservation reservation);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Reservation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param reservation 实例对象
     * @return 实例对象
     */
    Reservation insert(Reservation reservation);

    /**
     * 修改数据
     *
     * @param reservation 实例对象
     * @return 实例对象
     */
    Reservation update(Reservation reservation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
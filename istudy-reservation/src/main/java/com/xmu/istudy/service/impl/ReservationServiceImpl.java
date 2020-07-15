package com.xmu.istudy.service.impl;

import com.xmu.istudy.dao.ReservationDao;
import com.xmu.istudy.entity.Reservation;
import com.xmu.istudy.service.ReservationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Reservation)表服务实现类
 *
 * @author makejava
 * @since 2020-07-15 03:33:41
 */
@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {
    @Resource
    private ReservationDao reservationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Reservation queryById(Long id) {
        return this.reservationDao.queryById(id);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param reservation 实例对象
     * @return 对象列表
     */
    @Override
    public List<Reservation> queryAll(Reservation reservation) {
        return this.reservationDao.queryAll(reservation);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Reservation> queryAllByLimit(int offset, int limit) {
        return this.reservationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param reservation 实例对象
     * @return 实例对象
     */
    @Override
    public Reservation insert(Reservation reservation) {
        this.reservationDao.insert(reservation);
        return reservation;
    }

    /**
     * 修改数据
     *
     * @param reservation 实例对象
     * @return 实例对象
     */
    @Override
    public Reservation update(Reservation reservation) {
        this.reservationDao.update(reservation);
        return this.queryById(reservation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.reservationDao.deleteById(id) > 0;
    }
}
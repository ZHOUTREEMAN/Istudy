package com.xmu.istudy.service;


import com.xmu.istudy.entity.Admin;

import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2020-07-08 15:56:21
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**登录
     * @param userName
     * @param passW
     * @return
     */
    Admin login(String userName, String passW);

    /**
     * 注册
     * @param user
     * @return
     */
    Admin register(Admin user);

    /**
     * 通过名字查找
     * @param name
     * @return
     */
    Admin findByName(String name);

    /**
     * 通过工号查找
     * @param id
     * @return
     */
    Admin findByNo(long id);
}
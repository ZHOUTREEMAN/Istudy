package com.xmu.istudy.service;


import com.xmu.istudy.entity.Teacher;

import java.util.List;

/**
 * (Teacher)表服务接口
 *
 * @author makejava
 * @since 2020-07-08 15:54:04
 */
public interface TeacherService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Teacher queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Teacher> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    Teacher insert(Teacher teacher);

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    Teacher update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 登录
     * @param userName
     * @param passW
     * @return
     */
    Teacher login(String userName, String passW);

    /**
     * 注册
     * @param user
     * @return
     */
    Teacher register(Teacher user);


    /**
     * 通过名字查找
     * @param name
     * @return
     */
    Teacher findByName(String name);

    /**
     * 通过工号查找
     * @param id
     * @return
     */
    Teacher findByNo(long id);
}
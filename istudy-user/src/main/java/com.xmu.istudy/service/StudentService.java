package com.xmu.istudy.service;


import com.xmu.istudy.entity.Student;

import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author makejava
 * @since 2020-07-08 15:53:09
 */
public interface StudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 注册
     * @param user
     * @return student
     */
    Student register(Student user);

    /**
     * 学生登录
     * @param userName
     * @param passW
     * @return
     */
    Student login(String userName, String passW);

    /**通过姓名查找
     * @param name
     * @return
     */
    Student findByName(String name);

    /**
     * 通过学号查找
     * @param id
     * @return
     */
    Student findByNo(long id);
}
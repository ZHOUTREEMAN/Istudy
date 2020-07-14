package com.xmu.istudy.dao;

import com.xmu.istudy.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-08 15:53:08
 */
@Mapper
public interface StudentDao {

    /**
     * 通过学号查询单条数据
     *
     * @param id 学号
     * @return 实例对象
     */
    Student queryById(Long id);

    /**
     * 通过用户名查找学生
     * @param name
     * @return
     */
    Student queryByName(String name);

    /**
     * 通过邮箱查找学生
     * @param email
     * @return
     */
    Student queryByEmail(String email);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param student 实例对象
     * @return 对象列表
     */
    List<Student> queryAll(Student student);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}
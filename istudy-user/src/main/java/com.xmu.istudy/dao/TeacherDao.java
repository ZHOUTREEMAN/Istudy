package com.xmu.istudy.dao;


import com.xmu.istudy.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Teacher)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-08 15:54:04
 */
@Mapper
public interface TeacherDao {

    /**
     * 通过工号查询单条数据
     *
     * @param id 工号
     * @return 实例对象
     */
    Teacher queryById(Long id);

    /**
     * 通过姓名查询单条数据
     *
     * @param name 姓名
     * @return 实例对象
     */
    Teacher queryByName(String name);

    /**
     * 通过邮箱查询单条数据
     *
     * @param email
     * @return 实例对象
     */
    Teacher queryByEmail(String email);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Teacher> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param teacher 实例对象
     * @return 对象列表
     */
    List<Teacher> queryAll(Teacher teacher);

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int insert(Teacher teacher);

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}
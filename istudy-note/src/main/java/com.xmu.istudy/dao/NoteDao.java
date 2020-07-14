package com.xmu.istudy.dao;

import com.xmu.istudy.entity.Note;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 公告表(Note)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-13 14:59:10
 */
@Mapper
public interface NoteDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Note queryById(Long id);

    /**
     * 通过标题查询单条数据
     *
     * @param title 主键
     * @return 实例对象
     */
    Note queryByTitle(String title);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Note> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param note 实例对象
     * @return 对象列表
     */
    List<Note> queryAll(Note note);

    /**
     * 新增数据
     *
     * @param note 实例对象
     * @return 影响行数
     */
    int insert(Note note);

    /**
     * 修改数据
     *
     * @param note 实例对象
     * @return 影响行数
     */
    int update(Note note);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}
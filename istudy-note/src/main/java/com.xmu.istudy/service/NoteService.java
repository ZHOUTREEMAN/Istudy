package com.xmu.istudy.service;

import com.xmu.istudy.entity.Note;

import java.util.List;

/**
 * 公告表(Note)表服务接口
 *
 * @author makejava
 * @since 2020-07-13 14:59:10
 */
public interface NoteService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Note queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Note> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param note 实例对象
     * @return 实例对象
     */
    Note insert(Note note);

    /**
     * 修改数据
     *
     * @param note 实例对象
     * @return 实例对象
     */
    Note update(Note note);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 通过公告标题进行搜索
     * @param title
     * @return
     */
    Note findByTitle(String title);

    /**
     * 审核公告
     * @param noteId
     * @return
     */
    Note auditing(long noteId);
}
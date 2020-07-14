package com.xmu.istudy.service.impl;

import com.xmu.istudy.dao.NoteDao;
import com.xmu.istudy.entity.Note;
import com.xmu.istudy.service.NoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 公告表(Note)表服务实现类
 *
 * @author makejava
 * @since 2020-07-13 14:59:10
 */
@Service("noteService")
public class NoteServiceImpl implements NoteService {
    @Resource
    private NoteDao noteDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Note queryById(Long id) {
        return this.noteDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Note> queryAllByLimit(int offset, int limit) {
        return this.noteDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param note 实例对象
     * @return 实例对象
     */
    @Override
    public Note insert(Note note) {
        note.setLastUpdateTime(new Date());
        //默认未审核
        note.setStatus(0);
        this.noteDao.insert(note);
        return note;
    }

    /**
     * 修改数据
     *
     * @param note 实例对象
     * @return 实例对象
     */
    @Override
    public Note update(Note note) {
        note.setLastUpdateTime(new Date());
        //默认修改后未审核
        note.setStatus(0);
        this.noteDao.update(note);
        return this.queryById(note.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.noteDao.deleteById(id) > 0;
    }

    /**
     * 通过标题进行搜索
     * @param title
     * @return
     */
    @Override
    public Note findByTitle(String title) {
        return noteDao.queryByTitle(title);
    }

    /**
     * 审核公告
     * @param noteId
     * @return
     */
    @Override
    public Note auditing(long noteId) {
        Note note=noteDao.queryById(noteId);
        if(null!=note)
        {
            note.setStatus(1);
            note.setLastUpdateTime(new Date());
            noteDao.update(note);
            return note;
        }
        else
        {
            return null;
        }
    }
}
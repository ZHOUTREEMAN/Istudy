package com.xmu.istudy.service.impl;

import com.xmu.istudy.dao.TeacherDao;
import com.xmu.istudy.entity.Teacher;
import com.xmu.istudy.service.TeacherService;
import com.xmu.istudy.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * (Teacher)表服务实现类
 *
 * @author makejava
 * @since 2020-07-08 15:54:05
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Teacher queryById(Long id) {
        return this.teacherDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Teacher> queryAllByLimit(int offset, int limit) {
        return this.teacherDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public Teacher insert(Teacher teacher) {
        this.teacherDao.insert(teacher);
        return teacher;
    }

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public Teacher update(Teacher teacher) {
        teacher.setLastUpdateTime(new Date());
        this.teacherDao.update(teacher);
        return this.queryById(teacher.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.teacherDao.deleteById(id) > 0;
    }

    /**
     * 登录
     * @param userName
     * @param passW
     * @return
     */
    @Override
    public Teacher login(String userName, String passW) {

        Teacher teacher=teacherDao.queryByName(userName);
        if(null==teacher)
        {
            return null;
        }else
        {
            if(MD5Util.encrypt(passW).equals(teacher.getTeacherPassword())) {
                return teacher;
            } else {
                return null;
            }
        }
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public Teacher register(Teacher user) {
        Teacher temp=teacherDao.queryById(user.getTeacherNo());
        Teacher temp1=teacherDao.queryByName(user.getTeacherName());
        Teacher temp2=teacherDao.queryByEmail(user.getTeacherEmail());
        if(null==temp&&null==temp1&&null==temp2)
        {
            String passw=MD5Util.encrypt(user.getTeacherPassword());
            user.setTeacherPassword(passw);
            user.setLastUpdateTime(new Date());
            int result=teacherDao.insert(user);
            if(result==1)
            {
                return  user;
            }
            else {
                return null;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * 通过姓名查找
     * @param name
     * @return
     */
    @Override
    public Teacher findByName(String name) {
        return teacherDao.queryByName(name);
    }

    /**
     * 通过工号查找
     * @param id
     * @return
     */
    @Override
    public Teacher findByNo(long id) {
        return teacherDao.queryById(id);
    }
}
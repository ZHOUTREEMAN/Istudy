package com.xmu.istudy.service.impl;

import com.xmu.istudy.dao.StudentDao;
import com.xmu.istudy.entity.Student;
import com.xmu.istudy.service.StudentService;
import com.xmu.istudy.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2020-07-08 15:53:09
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Long id) {
        return this.studentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Student> queryAllByLimit(int offset, int limit) {
        return this.studentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student update(Student student) {
        student.setLastUpdateTime(new Date());
        this.studentDao.update(student);
        return this.queryById(student.getStudentNo());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.studentDao.deleteById(id) > 0;
    }

    /**
     * 学生注册
     * @param user
     * @return
     */
    @Override
    public Student register(Student user) {
        Student temp=studentDao.queryById(user.getStudentNo());
        Student temp1=studentDao.queryByName(user.getStudentName());
        Student temp2=studentDao.queryByEmail((user.getStudentEmail()));
        if(null==temp&&null==temp1&&null==temp2)
        {
            String passw=MD5Util.encrypt(user.getStudentPassword());
            user.setStudentPassword(passw);
            user.setLastUpdateTime(new Date());
            int result=studentDao.insert(user);
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
     * 学生登录
     * @param userName
     * @param passW
     * @return
     */
    @Override
    public Student login(String userName, String passW) {
        Student student=studentDao.queryByName(userName);
        if(null==student)
        {
            return null;
        }else
        {
            if(MD5Util.encrypt(passW).equals(student.getStudentPassword())) {
                return student;
            } else {
                return null;
            }
        }
    }

    /**
     * 通过名字查找
     * @param name
     * @return
     */
    @Override
    public Student findByName(String name) {

        return studentDao.queryByName(name);
    }

    /**
     * 通过学号查找
     * @param id
     * @return
     */
    @Override
    public Student findByNo(long id) {
        return studentDao.queryById(id);
    }
}
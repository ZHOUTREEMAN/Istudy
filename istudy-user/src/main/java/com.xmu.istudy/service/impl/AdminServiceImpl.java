package com.xmu.istudy.service.impl;

import com.xmu.istudy.dao.AdminDao;
import com.xmu.istudy.entity.Admin;
import com.xmu.istudy.service.AdminService;
import com.xmu.istudy.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2020-07-08 15:56:21
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Long id) {
        return this.adminDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Admin> queryAllByLimit(int offset, int limit) {
        return this.adminDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
        admin.setLastUpdateTime(new Date());
        this.adminDao.update(admin);
        return this.queryById(admin.getAdminNo());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.adminDao.deleteById(id) > 0;
    }

    /**
     * 登录
     * @param userName
     * @param passW
     * @return
     */
    @Override
    public Admin login(String userName, String passW) {
        Admin admin=adminDao.queryByName(userName);
        if(null==admin)
        {
            return null;
        }else
        {
            if(MD5Util.encrypt(passW).equals(admin.getAdminPassword())) {
                return admin;
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
    public Admin register(Admin user) {
        Admin temp=adminDao.queryById(user.getAdminNo());
        Admin temp1=adminDao.queryByName(user.getAdminName());
        Admin temp2=adminDao.queryByEmail(user.getAdminEmail());
        if(null==temp&&null==temp1&&null==temp2)
        {
            String passw=MD5Util.encrypt(user.getAdminPassword());
            user.setAdminPassword(passw);
            user.setLastUpdateTime(new Date());
            int result=adminDao.insert(user);
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
     * 通过名字查找
     * @param name
     * @return
     */
    @Override
    public Admin findByName(String name) {
        return adminDao.queryByName(name);
    }

    /**
     * 通过工号查找
     * @param id
     * @return
     */
    @Override
    public Admin findByNo(long id) {
        return adminDao.queryById(id);
    }
}
package com.xmu.istudy.service.impl;

import com.xmu.istudy.dao.AdminDao;
import com.xmu.istudy.dao.StudentDao;
import com.xmu.istudy.dao.TeacherDao;
import com.xmu.istudy.service.EmailService;
import com.xmu.istudy.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private AdminDao adminDao;
    @Override
    public Object findPasswEmail(String emailTo, String url,String type) {
        Object result;
        if(type=="student")
        {
            result=studentDao.queryByEmail(emailTo);
        }
        else if(type=="admin")
        {
            result=adminDao.queryByEmail(emailTo);
        }
        else
        {
            result=teacherDao.queryByEmail(emailTo);
        }
        if(null==result)
        {
            return result;
        }
        else
        {
            MailUtil.sendHtmlEmail(emailTo,"问答社区平台的密码找回",url);
            return result;
        }
    }
}

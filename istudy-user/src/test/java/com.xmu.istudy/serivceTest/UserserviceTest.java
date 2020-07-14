package com.xmu.istudy.serivceTest;
/**
 * @author xingzhou
 * @date 20220
 * @version 1.0
 */

import com.xmu.istudy.entity.Student;
import com.xmu.istudy.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserserviceTest {
    @Autowired
    private StudentService studentService;
    @Test
    void findAdById()
    {
        studentService.queryAllByLimit(5,4);
    }
    @Test
    void add()
    {
        Student student=new Student();
        student.setLastUpdateTime(new Date());
        student.setStatus(0);
        student.setStudentEmail("329201962@qq.com");
        student.setStudentGender(1);
        student.setStudentName("zzx");
        long id=32019;
        student.setStudentNo(id);
        student.setStudentPhone("18850013895");
        student.setStudentPassword("181118");
        studentService.insert(student);
    }
}

package com.xmu.istudy.controller;


import com.xmu.istudy.entity.Student;
import com.xmu.istudy.service.EmailService;
import com.xmu.istudy.service.StudentService;
import com.xmu.istudy.util.JwtUtils;
import com.xmu.istudy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2020-07-08 15:53:10
 */
@RestController
@RequestMapping("")
public class StudentController {
    /**
     * 服务对象
     */
    @Autowired
    private StudentService studentService;
    @Autowired
    private EmailService emailService;

    /**
     * 登录
     * @param userName
     * @param passW
     * @return
     */
    @PostMapping("/student/login")
    public Object login(@RequestParam String userName,
                        @RequestParam String passW)
    {
        Student result=studentService.login(userName,passW);
        if(null!=result) {
            //其他数据以map集合存放在token中
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("name", result.getStudentName());
            dataMap.put("no", result.getStudentNo());
            //生成token并存入数据返回
            JwtUtils jwtUtils=new JwtUtils();
            String token = jwtUtils.createJwt(result.getId().toString(), "student", dataMap);
            return ResponseUtil.ok(token);
        } else {
            return ResponseUtil.fail();
        }
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/student/register")
    public Object register(@RequestBody Student user)
    {
        Student result=studentService.register(user);
        if(null==result) {
            return ResponseUtil.fail();
        } else {
            return ResponseUtil.ok(result);
        }
    }

    /**
     * 查找所有
     * @param request
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/studentList")
    public Object findStudentList(HttpServletRequest request,
                                  @RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "10") Integer limit)
    {
        if(JwtUtils.ifauthz(request,"teacher")||JwtUtils.ifauthz(request,"admin"))
        {
            return ResponseUtil.ok(studentService.queryAllByLimit(page,limit));
        }
        else
        {
            return ResponseUtil.unauthz();
        }
    }

    /**
     * 修改信息
     * @param user
     * @return
     */
    @PutMapping("/student")
    public Object setUser(@RequestBody Student user)
    {
        Student result=studentService.update(user);
        if(null!=result) {
            return ResponseUtil.ok(result);
        } else {
            return ResponseUtil.fail();
        }
    }

    /**
     * 删除
     * @param request
     * @param userId
     * @return
     */
    @DeleteMapping("/student")
    public Object delUser(HttpServletRequest request,@RequestParam Integer userId)
    {

        if(JwtUtils.ifauthz(request,"admin"))
        {
            long id=userId;
            boolean result=studentService.deleteById(id);
            if(result) {
                return ResponseUtil.ok();
            } else {
                return ResponseUtil.fail();
            }
        }
        else
        {
            return ResponseUtil.unauthz();
        }
    }

    /**
     * 通过昵称查找
     * @param request
     * @param name
     * @return
     */
    @GetMapping("/student/{name}")
    public Object findStudent(HttpServletRequest request,@PathVariable String name)
    {
        if(JwtUtils.ifauthz(request,"admin")||JwtUtils.ifauthz(request,"teacher"))
        {
            Student result=studentService.findByName(name);
            if(result!=null) {
                return ResponseUtil.ok(result);
            } else {
                return ResponseUtil.fail();
            }
        }
        else
        {
            return ResponseUtil.unauthz();
        }
    }

    /**
     * 通过学号查找学生
     * @param request
     * @param userId
     * @return
     */
    @GetMapping("/student/no")
    public Object findStudentByNo(HttpServletRequest request,@RequestParam Integer userId)
    {
        if(JwtUtils.ifauthz(request,"admin")||JwtUtils.ifauthz(request,"teacher"))
        {
            long id=userId;
            Student result=studentService.findByNo(id);
            if(result!=null) {
                return ResponseUtil.ok(result);
            } else {
                return ResponseUtil.fail();
            }
        }
        else
        {
            return ResponseUtil.fail();
        }
    }

    /**
     * 通过邮箱找回密码
     * @param email
     * @param url
     * @return
     */
    @GetMapping("/student/forget")
    public Object findPassw(@RequestParam String email,@RequestParam String url)
    {
        Object result=emailService.findPasswEmail(email,url,"student");
        return ResponseUtil.ok(result);
    }

}
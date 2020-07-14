package com.xmu.istudy.controller;


import com.xmu.istudy.entity.Teacher;
import com.xmu.istudy.service.EmailService;
import com.xmu.istudy.service.TeacherService;
import com.xmu.istudy.util.JwtUtils;
import com.xmu.istudy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * (Teacher)表控制层
 *
 * @author makejava
 * @since 2020-07-08 15:54:05
 */
@RestController
@RequestMapping("")
public class TeacherController {
    /**
     * 服务对象
     */
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private EmailService emailService;

    /**
     * 登录
     * @param userName
     * @param passW
     * @return
     */
    @PostMapping("/teacher/login")
    public Object login(@RequestParam String userName,
                        @RequestParam String passW)
    {
        Teacher result=teacherService.login(userName,passW);
        if(null!=result) {
            //其他数据以map集合存放在token中
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("name", result.getTeacherName());
            dataMap.put("no", result.getTeacherNo());
            //生成token并存入数据返回
            JwtUtils jwtUtils=new JwtUtils();
            String token = jwtUtils.createJwt(result.getId().toString(), "teacher", dataMap);
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
    @PostMapping("/teacher/register")
    public Object register(@RequestBody Teacher user)
    {
        Teacher result=teacherService.register(user);
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
    @GetMapping("/teacherList")
    public Object findTeazcherList(HttpServletRequest request,
                                @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer limit)
    {
        if(JwtUtils.ifauthz(request,"admin"))
        {
            return ResponseUtil.ok(teacherService.queryAllByLimit((page-1)*limit,limit));
        }
        else
        {
            return ResponseUtil.unauthz();
        }
    }

    /**
     * 修改信息
     * @param request
     * @param user
     * @return
     */
    @PutMapping("/teacher")
    public Object setTeacher(HttpServletRequest request,@RequestBody Teacher user)
    {
        if(JwtUtils.ifauthz(request,"admin")||JwtUtils.ifauthz(request,"teacher"))
        {
            Teacher result=teacherService.update(user);
            if(null!=result) {
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
     * 删除
     * @param request
     * @param userId
     * @return
     */
    @DeleteMapping("/teacher")
    public Object delTeacher(HttpServletRequest request,@RequestParam Integer userId)
    {

        if(JwtUtils.ifauthz(request,"admin"))
        {
            long id=userId;
            boolean result=teacherService.deleteById(id);
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
    @GetMapping("/teacher/{name}")
    public Object findTeacher(HttpServletRequest request,@PathVariable String name)
    {
        if(JwtUtils.ifauthz(request,"admin"))
        {
            Teacher result=teacherService.findByName(name);
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
     * 通过工号查找
     * @param request
     * @param userId
     * @return
     */
    @GetMapping("/teacher/no")
    public Object findTeacherByNo(HttpServletRequest request,@RequestParam Integer userId)
    {
        if(JwtUtils.ifauthz(request,"admin"))
        {
            long id=userId;
            Teacher result=teacherService.findByNo(id);
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
    @GetMapping("/teacher/forget")
    public Object findPassw(@RequestParam String email,@RequestParam String url)
    {
        Object result=emailService.findPasswEmail(email,url,"teacher");
        return ResponseUtil.ok(result);
    }

}
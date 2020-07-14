package com.xmu.istudy.controller;


import com.xmu.istudy.entity.Admin;
import com.xmu.istudy.service.AdminService;
import com.xmu.istudy.service.EmailService;
import com.xmu.istudy.util.JwtUtils;
import com.xmu.istudy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-07-08 15:56:21
 */
@RestController
@RequestMapping("")
public class AdminController {
    /**
     * 服务对象
     */
    @Autowired
    private AdminService adminService;
    @Autowired
    private EmailService emailService;

    /**
     * 登录
     * @param userName
     * @param passW
     * @return
     */
    @PostMapping("/admin/login")
    public Object login(@RequestParam String userName,
                        @RequestParam String passW)
    {
        Admin result=adminService.login(userName,passW);
        if(null!=result) {
            //其他数据以map集合存放在token中
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("name", result.getAdminName());
            dataMap.put("no", result.getAdminNo());
            //生成token并存入数据返回
            JwtUtils jwtUtils=new JwtUtils();
            String token = jwtUtils.createJwt(result.getId().toString(), "admin", dataMap);
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
    @PostMapping("/admin/register")
    public Object register(@RequestBody Admin user)
    {
        Admin result=adminService.register(user);
        if(null==result) {
            return ResponseUtil.fail();
        } else {
            return ResponseUtil.ok(result);
        }
    }

    /**
     * 查询所有
     * @param request
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/adminList")
    public Object findAdminList(HttpServletRequest request,
                                  @RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "10") Integer limit)
    {
        if(JwtUtils.ifauthz(request,"admin"))
        {
            return ResponseUtil.ok(adminService.queryAllByLimit(page,limit));
        }
        else
        {
            return ResponseUtil.unauthz();
        }
    }

    /**
     * 修改个人信息
     * @param request
     * @param user
     * @return
     */
    @PutMapping("/admin")
    public Object setAdmin(HttpServletRequest request,@RequestBody Admin user)
    {
        if(JwtUtils.ifauthz(request,"admin"))
        {
            Admin result=adminService.update(user);
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
    @DeleteMapping("/admin")
    public Object delAdmin(HttpServletRequest request,@RequestParam Integer userId)
    {

        if(JwtUtils.ifauthz(request,"admin"))
        {
            long id=userId;
            boolean result=adminService.deleteById(id);
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
    @GetMapping("/admin/{name}")
    public Object findAdmin(HttpServletRequest request,@PathVariable String name)
    {
        if(JwtUtils.ifauthz(request,"admin"))
        {
            Admin result=adminService.findByName(name);
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
    @GetMapping("/admin/no")
    public Object findAdminByNo(HttpServletRequest request,@RequestParam Integer userId)
    {
        if(JwtUtils.ifauthz(request,"admin"))
        {
            long id=userId;
            Admin result=adminService.findByNo(id);
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
    @GetMapping("/admin/forget")
    public Object findPassw(@RequestParam String email,@RequestParam String url)
    {
        Object result=emailService.findPasswEmail(email,url,"admin");
        return ResponseUtil.ok(result);
    }
}
package com.xmu.istudy.controller;

import com.xmu.istudy.entity.Note;
import com.xmu.istudy.service.NoteService;
import com.xmu.istudy.util.JwtUtils;
import com.xmu.istudy.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 公告表(Note)表控制层
 *
 * @author makejava
 * @since 2020-07-13 14:59:13
 */
@RestController
@RequestMapping("")
public class NoteController {
    /**
     * 服务对象
     */
    @Resource
    private NoteService noteService;

    /**
     * 新建公告
     * @param request
     * @param note
     * @return
     */
    @PostMapping("/note")
    public Object newNote(HttpServletRequest request, @RequestBody Note note)
    {
        if(JwtUtils.ifauthz(request,"admin")||JwtUtils.ifauthz(request,"teacher"))
        {
            Note result=noteService.insert(note);
            if(null==result) {
                return ResponseUtil.fail();
            } else {
                return ResponseUtil.ok(result);
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
     * @param id
     * @return
     */
    @DeleteMapping("/note/{id}")
    public Object delNote(HttpServletRequest request, @PathVariable Integer id)
    {
        if(JwtUtils.ifauthz(request,"admin"))
        {
            long noteid=id;
            boolean result=noteService.deleteById(noteid);
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
     * 修改公告
     * @param request
     * @param note
     * @return
     */
    @PutMapping("/note")
    public Object fixNote(HttpServletRequest request,@RequestBody Note note)
    {
        if(JwtUtils.ifauthz(request,"admin")||JwtUtils.ifauthz(request,"teacher"))
        {
            Note result=noteService.update(note);
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
     * 审核公告
     * @param request
     * @param id
     * @return
     */
    @PutMapping("/note/admin")
    public Object auditing(HttpServletRequest request,@RequestParam Integer id)
    {
        if(JwtUtils.ifauthz(request,"admin"))
        {
            long noteId=id;
            Note result=noteService.auditing(noteId);
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
     * 查找所有
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/noteList")
    public Object findNoteList(
                                  @RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "10") Integer limit)
    {

        return ResponseUtil.ok(noteService.queryAllByLimit(page,limit));
    }

    /**
     * 按标题查找
     * @param title
     * @return
     */
    @GetMapping("/student/{title}")
    public Object findStudent(@PathVariable String title)
    {
            Note result=noteService.findByTitle(title);
            if(result!=null) {
                return ResponseUtil.ok(result);
            } else {
                return ResponseUtil.fail();
            }
    }

    /**
     * 按id查找
     * @param id
     * @return
     */
    @GetMapping("/student/id")
    public Object findStudentByNo(@RequestParam Integer id)
    {
            long noteId=id;
            Note result=noteService.queryById(noteId);
            if(result!=null) {
                return ResponseUtil.ok(result);
            } else {
                return ResponseUtil.fail();
            }
    }

}
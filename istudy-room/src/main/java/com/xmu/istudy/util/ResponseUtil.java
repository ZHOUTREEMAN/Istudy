package com.xmu.istudy.util;

import java.util.HashMap;
import java.util.Map;


public class ResponseUtil {


    public static Object ok() {
        Map<String, Object> obj = new HashMap<String, Object>(0);
        obj.put("errno", 0);
        obj.put("errmsg", "成功");
        return obj;
    }

    public static Object ok(Object data) {
        Map<String, Object> obj = new HashMap<String, Object>(0);
        obj.put("errno", 0);
        obj.put("errmsg", "成功");
        obj.put("data", data);
        return obj;
    }

    public static Object fail() {
        Map<String, Object> obj = new HashMap<String, Object>(0);
        obj.put("errno", -1);
        obj.put("errmsg", "错误");
        return obj;
    }

    public static Object fail(int errno, String errmsg) {
        Map<String, Object> obj = new HashMap<String, Object>(0);
        obj.put("errno", errno);
        obj.put("errmsg", errmsg);
        return obj;
    }

    public static Object illegalParameter() { return fail(580, "参数不合法"); }

    public static Object addFail() { return fail(741, "新增自习室失败"); }

    public static Object updateFail() { return fail(742, "自习室修改失败"); }

    public static Object deleteFail() { return fail(743, "自习室删除失败"); }

    public static Object getFail() { return fail(744, "自习室不存在"); }

    public static Object unlogin() { return fail(744, "未登录"); }


}

package com.xmu.istudy.util;

public class MailConfig {
    private static final String PROPERTIES_DEFAULT = "/mailConfig.properties";
    public static String host;//用什么邮件服务器
    public static Integer port;//端口
    public static String userName;//用户名，即账号
    public static String passWord;//授权码，不是登录密码
    public static String timeout;
    static{
        init();
    }

    /**
     * 初始化
     */
    private static void init() {
        host = "smtp.qq.com";
        port = 465;
        userName = "329201962@qq.com";
        passWord = "awmuxvclsezkbgec";
        timeout = "25000";
    }
}
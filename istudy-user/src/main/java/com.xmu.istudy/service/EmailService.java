package com.xmu.istudy.service;

public interface EmailService {
    /**
     * 通过邮箱找回密码
     * @param emailTo
     * @param url
     * @return
     */
    public Object findPasswEmail(String emailTo, String url,String type);
}


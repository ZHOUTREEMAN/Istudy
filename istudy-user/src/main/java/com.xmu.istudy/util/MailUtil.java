package com.xmu.istudy.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class MailUtil {
    public static void sendHtmlEmail(String emailTo,String subject,String context){
        // 不使用SimpleEmail,会出现乱码问题
        HtmlEmail email = new HtmlEmail();
        // SimpleEmail email = new SimpleEmail();
        try {
            // 这里是SMTP发送服务器的名字：163的如下：
            email.setHostName(MailConfig.host);
            email.setSSLOnConnect(true);//设置用ssl协议发送邮件
            System.out.println(MailConfig.port);
            email.setSmtpPort(MailConfig.port);
            // 字符编码集的设置
            email.setCharset("gbk");
            // 收件人的邮箱
            email.addTo(emailTo);
            // 发送人的邮箱
            email.setFrom(MailConfig.userName,"");
            // 如果需要认证信息的话，设置认证：用户名-授权码。分别为发件人在邮件服务器上的注册名称和设置的授权码，
            email.setAuthentication(MailConfig.userName, MailConfig.passWord);
            email.setSubject(subject);
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            email.setMsg("<h1 style='text-align:center'>"+subject+"</h1>"
                    +"<h2 >"+"尊敬的用户您好："+"<br/><br/>"+"  请点击链接修改您的帐号密码。如果以上链接无法点击，请将它复制到你的浏览器地址栏中进入访问。如果此次激活请求非你本人所发，请忽略本邮件。"+"<br/>"+"   Please click the link to change your account password.If the above link cannot be clicked, please copy it to your browser address bar to access it.If this activation request is not from you, please ignore this email.</h2>"
                    +"<br/>"
                    +"<a style='text-align:center' href=\""+context+"\">请点击此链接进行新密码的设置："+context+"</a>");
            // 发送
            email.send();

            System.out.println("邮件发送成功!");
        } catch (EmailException e) {
            e.printStackTrace();
            System.out.println("邮件发送失败!");
        }
    }
    public static void main(String args [])
    {
        sendHtmlEmail("3231877375@qq.com","Istudy平台的密码找回","http://www.baidu.com");
    }
}
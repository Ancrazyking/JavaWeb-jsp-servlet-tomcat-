package org.afeng.mall.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * @author afeng
 * @date 2018/8/24 20:03
 * <p>
 * <p>
 * 发送邮件的工具类
 **/
public class MailUtils
{
    public static void sendMail(String email, String emailMsg) throws Exception
    {
        Properties properties = new Properties();

        /**
         * 创建验证器
         */
        Authenticator authenticator = new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                //设置发送人的账号和密码
                return new PasswordAuthentication("admin@store.com", "admin");
            }
        };

        //创建一个会话
        Session session = Session.getInstance(properties, authenticator);

        //创建一个Message,邮件的内容
        Message message = new MimeMessage(session);

        //设置发送者
        message.setFrom(new InternetAddress("admin@store.com"));

        //设置发送方式与接收者
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

        //设置邮件的主题
        message.setSubject("用户激活");

        String url = "http://localhost:8080/UserServlet?method=active&code=" + emailMsg;
        String content = "<h1>来自商城的激活邮件!激活请点击以下链接!</h1><h3><a href='" + url + "'>"
                + url + "</a></h3>";

        //设置邮件的内容
        message.setContent(content, "text/html;charset=utf-8");

        //创建Transport发送邮件
        Transport.send(message);
    }

    public static void main(String[] args) throws Exception
    {
        sendMail("aaa@store.com", "9782f3e837ff422b9aee8b6381ccf927bdd9d2ced10d48f4ba4b9f187edf7738");
    }

}

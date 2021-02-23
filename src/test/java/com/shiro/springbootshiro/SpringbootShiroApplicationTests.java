package com.shiro.springbootshiro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootShiroApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("245364863@qq.com");
        simpleMailMessage.setFrom("245364863@qq.com");
        simpleMailMessage.setSubject("bill 哔哩哩");
        simpleMailMessage.setText("hello");
        mailSender.send(simpleMailMessage);
    }


    @Test
    void contextLoads2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("245364863@qq.com");
        mimeMessageHelper.setTo("1764046286@qq.com");
        mimeMessageHelper.addAttachment("bill.jpg", new File("C:\\Users\\bill\\Pictures\\Camera Roll\\123.jpg"));
        mimeMessageHelper.addAttachment("bill2.jpg", new File("C:\\Users\\bill\\Pictures\\Camera Roll\\17.jpg"));

        mimeMessageHelper.setText("<h2 style='color:red'>hello ,i send mail  in java code for you,you know?</h2>",true);
        mimeMessageHelper.setSubject("bill's mail");
        mailSender.send(mimeMessage);
    }
}

package com.jbf.spring.jbfspringmail.service;

import com.jbf.spring.jbfspringmail.util.JavaMailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Resource
    JavaMailUtil javaMailUtil;

    @Resource
    TemplateEngine templateEngine;

    @Test
    public void sendSimpleMail() {
        javaMailUtil.sendSimpleMail("1160362008@qq.com","这是第一封邮件","大家好,这是普通文本邮件");
    }

    @Test
    public void sendHtmlMailTest() {
        String content= "<html>\n" +
                "<body>\n" +
                "<h3>这是一封Html邮件</h3>\n" +
                "</body>\n" +
                "</html>";
        javaMailUtil.sendHtmlMail("1160362008@qq.com","这是一封HTML邮件", content);
    }

    @Test
    public void sendAttachmentsMailTest() {
        String filePath= "F://";
        javaMailUtil.sendAttachmentsMail("1160362008@qq.com","这是一封带附件的邮件",
                "带附件的邮件正文", filePath);
    }

    @Test
    public void sendInlinResourceMailTest() {
        String imgPath= "F://";
        String rscId = "img001";
        String content = "<html>\n" +
                "<body>\n" +
                "<h3>这是一封有图片的邮件</h3>\n" +
                "<img src=\'cid:>" + rscId + "\'></img>" +
                "</body>\n" +
                "</html>";
        javaMailUtil.sendInlinResourceMail("1160362008@qq.com","这是一封带附件的邮件",
                content, imgPath, rscId);
    }
    @Test
    public void sendTemplateMailTest() {
        Context context = new Context();
        context.setVariable("id", "2019");
        String emailContent = templateEngine.process("emailTemplate", context);
        javaMailUtil.sendHtmlMail("1160362008@qq.com","这是一封HTML邮件", emailContent);

    }
}

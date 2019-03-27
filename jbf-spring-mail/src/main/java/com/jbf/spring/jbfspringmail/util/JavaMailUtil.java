package com.jbf.spring.jbfspringmail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class JavaMailUtil {
    @Value("${spring.mail.username}")
    private String fromMail;
    @Autowired
    private JavaMailSender javaMailSender;
    /**
     * 发送普通文本邮件
     */
    public void sendSimpleMail(String toMail, String subject,
                                      String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toMail);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailMessage.setFrom(fromMail);
        javaMailSender.send(mailMessage);
    }

    /**
     *发送HTML邮件
     */
    public void sendHtmlMail(String toMail, String subject,
                             String content) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(toMail);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);
            mimeMessageHelper.setFrom(fromMail);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {
        }

    }

    /**
     * 发送带附件的邮件
     */
    public void sendAttachmentsMail(String toMail, String subject,
                                    String content, String filePath) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(toMail);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);
            mimeMessageHelper.setFrom(fromMail);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
            String fileName = fileSystemResource.getFilename();
            mimeMessageHelper.addAttachment(fileName, fileSystemResource);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {
        }

    }
    /**
     * 发送带图片的邮件
     */
    public void sendInlinResourceMail(String toMail, String subject,  String content,
                                      String rscPath, String rscId) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(toMail);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);
            mimeMessageHelper.setFrom(fromMail);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(rscPath));

            mimeMessageHelper.addInline(rscId, fileSystemResource);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {
        }
    }

    /**
     * 发送邮件模板
     */
}

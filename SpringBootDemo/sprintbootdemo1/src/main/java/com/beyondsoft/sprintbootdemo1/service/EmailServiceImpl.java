package com.beyondsoft.sprintbootdemo1.service;

import com.beyondsoft.sprintbootdemo1.email.EmailConfig;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfig;

    @Override
    public void sendSimpleEmail(String sendTo, String title, String content) {
        //简单邮件发送
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailConfig.getEmailFrom());
        message.setTo(sendTo); //邮箱地址
        message.setSubject(title);//邮件标题
        message.setText(content);//邮件内容
        mailSender.send(message);
    }

    @Override
    public void sendAttachmentMail(String sendTo, String title, String content, File file) {
        MimeMessage msg = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(msg,true);
            helper.setFrom(emailConfig.getEmailFrom());
            helper.setTo(sendTo);
            helper.setSubject(title);
            helper.setText(content);

            FileSystemResource r = new FileSystemResource(file); //附件文件
            helper.addAttachment("附件",r);
        }catch (Exception e){
            e.printStackTrace();
        }
        mailSender.send(msg);
    }

    @Override
    public void sendTemplateMail(String sendTo, String title, String info) {
        MimeMessage msg = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(msg,true);
            helper.setFrom(emailConfig.getEmailFrom()); //发送人
            helper.setTo(sendTo);//发给谁
            helper.setSubject(title);

            //封装模板使用数据
            Map<String,Object> model = new HashMap<>();
            model.put("username","虚竹");

            //得到模板
            Template template =  freeMarkerConfig.getConfiguration().getTemplate(info);
            //把数据用到模板当中,把模板转换成字符串
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
            helper.setText(html,true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSender.send(msg);
    }
}

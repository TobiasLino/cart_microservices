package com.example.eureka.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String send(SimpleMail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setText(mail.getText());
        mailMessage.setTo(mail.getTo());
        mailMessage.setFrom(mail.getFrom());

        return send(mailMessage);
    }

    private String send(SimpleMailMessage mailMessage) {
        try {
            javaMailSender.send(mailMessage);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "FAIL";
        }
    }
}

package com.example.eureka.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/mail")
public class EmailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send")
    public String send(@RequestBody SimpleMail mail) {
        return mailService.send(mail);
    }
}

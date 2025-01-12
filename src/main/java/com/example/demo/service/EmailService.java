package com.example.demo.service;

import com.example.demo.exception.EmailFailureException;
import com.example.demo.model.VerificationToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${email.from}")
    private String fromAdress;

    @Value("${app.frontend.url}")
    private String frontendUrl;

    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    private SimpleMailMessage makeEmailConformationMessage(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromAdress);
        return message;
    }

    public void sendEmailConformationMessage(VerificationToken verificationToken) throws EmailFailureException {
        SimpleMailMessage message = makeEmailConformationMessage();
        message.setTo(verificationToken.getLocalUser().getEmail());
        message.setSubject("Verify the email to activate your account");
        message.setText("Please follow the link to activate your account.\n" +
                frontendUrl+"/auth/verify?token="+verificationToken.getToken());
        try{
            javaMailSender.send(message);
        }
        catch(MailException ex){
            throw new EmailFailureException();
        }

    }

}

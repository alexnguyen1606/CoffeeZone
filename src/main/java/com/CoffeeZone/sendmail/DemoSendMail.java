package com.CoffeeZone.sendmail;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
public class DemoSendMail {
    public static void main(String[] args) throws MessagingException {
        sendText();
    }
    public static void sendText() throws MessagingException {
        ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
        MailSender mailSender = (MailSender) context.getBean("mailSender1");
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("natuan1606@gmail.com");
        message.setTo("nguyenanhtuan01684066197@gmail.com");
        message.setSubject("Subject");
        message.setText("test send gmail using spring");

        // sending message
        mailSender.send(message);
        System.out.println("Sending text done!");
        context.close();
    }
}

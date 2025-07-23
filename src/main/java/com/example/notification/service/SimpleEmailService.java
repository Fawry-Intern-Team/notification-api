package com.example.notification.service;

import lombok.RequiredArgsConstructor;
import org.example.events.NotificationEvent;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class  SimpleEmailService implements NotificationStrategy {


    private final JavaMailSender mailSender;

    @Override
    public void send(NotificationEvent event) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(event.getRecipient());
        message.setSubject(event.getSubject());
        message.setText(event.getContent());

        mailSender.send(message);
    }
}

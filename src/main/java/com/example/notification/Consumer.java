package com.example.notification;

import com.example.notification.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.example.events.NotificationEvent;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Consumer {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(Consumer.class);
    private final SimpleEmailService emailService;

    @RabbitListener(queues = "notification-queue")
    public void consumeMessage(NotificationEvent event) {
        emailService.send(event);
    }
}

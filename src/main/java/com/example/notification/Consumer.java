package com.example.notification;

import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = "order-queue")
    public void consumeMessage(MessageDTO message) {
        logger.info("Received message: Order ID: {}, Product ID: {}, Quantity: {}, Customer ID: {}, Status: {}",
                message.getOrderId(),
                message.getProductId(),
                message.getQuantity(),
                message.getCustomerId(),
                message.getStatus());

        // Here you can add logic to process the message, e.g., update a database, send a notification, etc.
    }
}

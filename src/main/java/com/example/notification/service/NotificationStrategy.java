package com.example.notification.service;

import org.example.events.NotificationEvent;

public interface NotificationStrategy {
    void send(NotificationEvent event);
}

package org.example.listener;

import org.example.service.EmailNotificationService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    private final EmailNotificationService emailNotificationService;

    public EmailNotificationListener(EmailNotificationService emailNotificationService) {
        this.emailNotificationService = emailNotificationService;
    }

    @JmsListener(destination = "changeQueue")
    public void onMessage(String message) {
        emailNotificationService.checkAndSendEmail(message);
    }
}

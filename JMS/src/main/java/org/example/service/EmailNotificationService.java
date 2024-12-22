package org.example.service;

import org.example.model.EmailNotification;
import org.example.repository.EmailNotificationRepository;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailNotificationService {

    private final EmailNotificationRepository emailNotificationRepository;
    private final JavaMailSender mailSender;

    public EmailNotificationService(EmailNotificationRepository emailNotificationRepository, JavaMailSender mailSender) {
        this.emailNotificationRepository = emailNotificationRepository;
        this.mailSender = mailSender;
    }

    public void checkAndSendEmail(String message) {
        List<EmailNotification> notifications = emailNotificationRepository.findNotificationsForChange(message);

        for (EmailNotification notification : notifications) {
            sendEmail(notification);
        }
    }

    private void sendEmail(EmailNotification notification) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(notification.getEmail());
        mailMessage.setSubject("Entity Change Notification");
        mailMessage.setText("A change has occurred: " + notification.getConditionInfo());
        mailSender.send(mailMessage);
    }
}

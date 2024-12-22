package org.example.listener;

import org.example.service.ChangeLogService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ChangeLogListener {

    private final ChangeLogService changeLogService;

    public ChangeLogListener(ChangeLogService changeLoggerService) {
        this.changeLogService = changeLoggerService;
    }

    @JmsListener(destination = "changeQueue")
    public void onMessage(String message) {
        changeLogService.processChangeLog(message);
    }
}

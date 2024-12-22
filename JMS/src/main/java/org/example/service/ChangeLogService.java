package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.ChangeLog;
import org.example.repository.ChangeLogRepository;
import org.springframework.stereotype.Service;

@Service
public class ChangeLogService {

    private final ChangeLogRepository changeLogRepository;
    private final ObjectMapper objectMapper;

    public ChangeLogService(ChangeLogRepository changeLogRepository, ObjectMapper objectMapper) {
        this.changeLogRepository = changeLogRepository;
        this.objectMapper = objectMapper;
    }

    public void processChangeLog(String message) {
        try {
            ChangeLog changeLog = objectMapper.readValue(message, ChangeLog.class);
            changeLogRepository.save(changeLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
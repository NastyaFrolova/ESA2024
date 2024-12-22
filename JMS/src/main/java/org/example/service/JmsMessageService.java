package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.ChangeLog;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import org.example.model.Author;
import org.example.model.Book;

@Service
public class JmsMessageService {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    public JmsMessageService(JmsTemplate jmsTemplate, ObjectMapper objectMapper) {
        this.jmsTemplate = jmsTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendChangeMessage(Object entity, String changeType) {
        try {
            ChangeLog message = new ChangeLog();
            String entityType = entity.getClass().getSimpleName();
            message.setChangeType(changeType);
            message.setEntityType(entityType);
            message.setEntityId(getEntityId(entity));

            String changedData = objectMapper.writeValueAsString(entity);
            message.setChangeType(changedData);

            jmsTemplate.convertAndSend("changeQueue", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Long getEntityId(Object entity) {
        if (entity instanceof Author) {
            return ((Author) entity).getId();
        } else if (entity instanceof Book) {
            return ((Book) entity).getId();
        }
        return null;
    }
}

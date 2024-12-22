package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(schema = "public",name = "change_log")
public class ChangeLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long changeId;

    @Column
    private String changeType;

    @Column
    private String entityType;

    @Column
    private Long entityId;

    @Column
    private String changedData;

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getNewValue() {
        return changedData;
    }

    public void setNewValue(String newValue) {
        this.changedData = changedData;
    }

    @Override
    public String toString() {
        return "ChangeMessage{" +
                "changeType='" + changeType + '\'' +
                ", entityName='" + entityType + '\'' +
                ", entityId=" + entityId +
                ", changedData='" + changedData + '}';
    }
}
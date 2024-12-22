package org.example.model;

import jakarta.persistence.*;


@Entity
@Table(name = "email_notifications")
public class EmailNotification  {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "conditionInfo")
    private String conditionInfo;

    @Column(name = "entityType")
    private String entityType;

    @Column(name = "entityAttribute")
    private String entityAttribute;

    @Column(name = "conditionValue")
    private String conditionValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConditionInfo() {
        return conditionInfo;
    }

    public void setConditionInfo(String conditionInfo) {

        this.conditionInfo = conditionInfo;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {

        this.entityType = entityType;
    }
    public String getEntityAttribute() {
        return entityAttribute;
    }

    public void setEntityAttribute(String entityAttribute) {

        this.entityAttribute = entityAttribute;
    }
    public String getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(String conditionValue) {

        this.conditionValue = conditionValue;
    }


    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", email=" + email +
                ", conditionInfo=" + conditionInfo +
                ", entityAttribute=" + entityAttribute +
                ", conditionValue=" + conditionValue +
                '}';
    }
}

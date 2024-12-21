package org.example.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(schema = "public", name = "books")
public class Books {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="publish_date")
    private Date publishdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }


    @Override
    public String toString() {
        return "Books{id=" + id + ", title='" + title + "', publishdate=" + publishdate + '}';
    }
}

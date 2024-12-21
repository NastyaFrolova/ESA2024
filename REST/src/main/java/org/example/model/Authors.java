package org.example.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "public",name = "authors")
public class Authors {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="birth_date")
    private Date birthdate;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Books> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getbirthDate() {
        return birthdate;
    }

    public void setbirthDate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Authors{id=" + id + ", name='" + name + "', birthdate =" + birthdate+ "}";
    }
}

package org.example.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "public", name = "authors")
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="birth_date")
    private Date birthdate;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Book> books;

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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{id=" + id + ", name='" + name + "', birthdate =" + birthdate+ "}";
    }
    public Author() {
        this.id = 1L;
        this.name = "KOHH";
        this.birthdate = new Date();
    }

}

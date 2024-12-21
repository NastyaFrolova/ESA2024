package org.example.bean;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;

import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.service.AuthorService;
import org.example.service.BookService;

import javax.ejb.EJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named("authorBean")
@ViewScoped
public class AuthorBean implements Serializable {
    @Inject
    transient private BookService bookService;
    @Inject
    transient private AuthorService authorService;

    private Long id;
    private String name;
    private Date birthdate;

    private List<Author> authors;
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


    public List<Author> getAuthors() {
        authors = authorService.getAllAuthors();
        return authors;
    }

    public void addAuthor() {
        Author author = new Author();
        author.setId(id);
        author.setName(name);
        author.setBirthdate(birthdate);
        authorService.createAuthor(author);
        authors = authorService.getAllAuthors();
    }
}
package org.example.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.service.AuthorService;
import org.example.service.BookService;

import javax.ejb.EJB;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named("bookBean")
@ViewScoped
public class BookBean implements Serializable {

    @Inject
    transient private BookService bookService;
    @Inject
    transient private AuthorService authorService;

    private String title;
    private Date publishdate;
    private Long authorId;

    private List<Book> books;

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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public List<Book> getBooks() {
        if (books == null) {
            books = bookService.getAllBooks();
        }
        return books;
    }

    public List<Book> getBooksByAuthor(Long authorId) {
        return bookService.getBooksByAuthor(authorId);
    }

//    public void addBook() {
//        Author author = authorService.getAuthorById(authorId); // Get the author by ID
//        if (author != null) {
//            Book book = new Book();
//            book.setTitle(title);
//            book.setPublishdate(publishdate);
//            bookService.addBook(book);
//        }
//    }
}


package org.example.service;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.example.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void createBook(String title, Date publishdate, Long authorId) {
        Books book = new Books();
        book.setTitle(title);
        book.setPublishdate(publishdate);
        bookRepository.save(book);
    }

    public List<Books> getAllBooks() {
        List<Books> booksList = new ArrayList<>();
        bookRepository.findAll().forEach(booksList::add);
        return booksList;
    }

    public Books getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void saveBook(Books book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

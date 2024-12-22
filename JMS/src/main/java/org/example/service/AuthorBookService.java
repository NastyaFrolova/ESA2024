package org.example.service;

import org.example.model.Author;
import org.example.model.Book;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;

@Service
public class AuthorBookService {
    @Autowired
    private JmsMessageService JmsMessageService;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public void createAuthorWithBooks() {
        Author author = new Author();
        author.setName("J.K. Rowling");
        author.setBirthDate(new Date());

        Book book1 = new Book();
        book1.setTitle("Harry Potter and the Philosopher's Stone");
        book1.setPublishdate(new Date());

        Book book2 = new Book();
        book2.setTitle("Harry Potter and the Chamber of Secrets");
        book2.setPublishdate(new Date());

        bookRepository.saveAll(Arrays.asList(book1, book2));

        authorRepository.save(author);

        JmsMessageService.sendChangeMessage(author, "CREATE");
        JmsMessageService.sendChangeMessage(book1, "CREATE");
        JmsMessageService.sendChangeMessage(book2, "CREATE");
    }
}

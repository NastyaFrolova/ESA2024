package org.example.service;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entity.Book;

import java.util.List;

@Dependent
public class BookService {
    @PersistenceContext
    private EntityManager em;

    public void addBook(Book book) {
        em.persist(book);
    }

    public Book getBook(Long id) {
        return em.find(Book.class, id);
    }

    public void removeBook(Long id) {
        Book book = em.find(Book.class, id);
        if (book != null) {
            em.remove(book);
        }
    }

    public List<Book> getAllBooks() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public List<Book> getBooksByAuthor(Long authorId) {
        return em.createQuery("SELECT b FROM Book b WHERE b.author.id = :authorId", Book.class)
                .setParameter("authorId", authorId)
                .getResultList();
    }
}

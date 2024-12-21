package org.example.service;


import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entity.Author;

import java.util.List;

@Dependent
public class AuthorService {
    @PersistenceContext
    private EntityManager em;

    public void createAuthor(Author author) {
        em.persist(author);
    }

    public Author getAuthor(Long id) {
        return em.find(Author.class, id);
    }

    public void removeAuthor(Long id) {
        Author author = em.find(Author.class, id);
        if (author != null) {
            em.remove(author);
        }
    }

    public List<Author> getAllAuthors() {
        return em.createQuery("SELECT m FROM Author m", Author.class).getResultList();
    }

    public Author getAuthorById(Long id) {
        return em.find(Author.class, id);
    }
}
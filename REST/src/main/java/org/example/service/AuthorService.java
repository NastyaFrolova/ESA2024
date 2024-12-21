package org.example.service;
import org.example.repository.AuthorRepository;
import org.example.model.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Authors createAuthor(String name, Date birthdate) {
        Authors author = new Authors();
        author.setName(name);
        author.setbirthDate(birthdate);
        return authorRepository.save(author);
    }

    public List<Authors> getAllAuthors() {
        List<Authors> authorsList = new ArrayList<>();
        authorRepository.findAll().forEach(authorsList::add);
        return authorsList;
    }

    public Authors getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public void saveAuthor(Authors author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}

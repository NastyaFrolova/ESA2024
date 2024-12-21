package org.example.controller;

import org.example.repository.AuthorRepository;
import org.example.model.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<Authors> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Authors> getAuthorById(@PathVariable Long id) {
        return authorRepository.findById(id)
                .map(author -> ResponseEntity.ok(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Authors createAuthor(@RequestBody Authors author) {
        return authorRepository.save(author);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
        return authorRepository.findById(id).map(author -> {
            authorRepository.delete(author);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
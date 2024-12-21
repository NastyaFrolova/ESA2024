package org.example.controller;
import org.example.repository.BookRepository;
import org.example.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(book -> ResponseEntity.ok(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @GetMapping(value = "/author/{authorId}")
//    public List<Books> getBooksByAuthor(@PathVariable Long authorId) {
//        return bookRepository.findByAuthorId(authorId);
//    }

    @PostMapping
    public Books createBook(@RequestBody Books book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        return bookRepository.findById(id).map(book -> {
            bookRepository.delete(book);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

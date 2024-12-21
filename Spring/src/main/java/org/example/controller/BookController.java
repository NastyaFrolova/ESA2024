package org.example.controller;
import org.example.service.BookService;
import org.example.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(Model model) {
        List<Books> books = bookService.getAllBooks();
        model.addAttribute("books2", books);
        model.addAttribute("books", new Books());

        return "books";
    }

    @PostMapping
    public String createBook(@ModelAttribute Books book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }
}


package org.example.controller;

import org.example.service.AuthorService;
import org.example.model.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String getAllAuthors(Model model) {
        List<Authors> authors = authorService.getAllAuthors();
        model.addAttribute("authors2", authors);
        model.addAttribute("authors", new Authors());

        return "authors";
    }

    @PostMapping
    public String createAuthor(@ModelAttribute Authors author) {
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }
}
package com.czu.project.controller;

import com.czu.project.entity.Book;
import com.czu.project.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class BookController {
    private BookRepository bookRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "/index";
    }
}

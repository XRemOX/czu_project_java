package com.czu.project.controller;

import com.czu.project.entity.Book;
import com.czu.project.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    @GetMapping("/")
    public String index(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "/book/bookIndex";
    }

    @GetMapping("/addNew")
    public String addNewBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/book/newBook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "/book/updateBook";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") int id) {
        bookService.deleteById(id);
        return "redirect:/";
    }
}

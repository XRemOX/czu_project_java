package com.czu.project.restcontroller;

import com.czu.project.entity.Book;
import com.czu.project.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/book")
public class BookRESTController {
    private BookService bookService;

    @GetMapping
    List<Book> allBooks() {
        return bookService.findAll();
    }

    @PostMapping
    void newBook(@RequestBody Book book) {
        bookService.save(book);
    }

    @GetMapping("/{id}")
    Book getBookById(@PathVariable int id) {
        return bookService.findById(id);
    }

    @PutMapping
    Book updateBook(@RequestBody Book book) {
        bookService.save(book);
        return book;
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable int id) {
        bookService.deleteById(id);
    }
}

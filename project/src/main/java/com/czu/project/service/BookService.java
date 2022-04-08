package com.czu.project.service;

import com.czu.project.entity.Book;
import com.czu.project.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements ServiceInt<Book> {
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}

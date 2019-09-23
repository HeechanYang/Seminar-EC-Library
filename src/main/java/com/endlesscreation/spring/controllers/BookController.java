package com.endlesscreation.spring.controllers;

import com.endlesscreation.spring.dtos.SimpleResponse;
import com.endlesscreation.spring.models.Book;
import com.endlesscreation.spring.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            return bookService.getBooksByName(name);
        } else {
            return bookService.getAllBooks();
        }
    }

    @GetMapping("/{id}")
    public Book getBooksById(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public SimpleResponse insertBook(@RequestBody Book book) {
        return bookService.insertBook(book);
    }

    @PutMapping("/{id}")
    public SimpleResponse updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse deleteBook(@PathVariable("id") int id) {
        return bookService.deleteBook(id);
    }

}

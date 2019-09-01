package com.endlesscreation.spring.controllers;

import com.endlesscreation.spring.models.Book;
import com.endlesscreation.spring.models.Borrowing;
import com.endlesscreation.spring.services.BookService;
import com.endlesscreation.spring.services.BorrowingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BorrowingService borrowingService;

    public BookController(BookService bookService, BorrowingService borrowingService) {
        this.bookService = bookService;
        this.borrowingService = borrowingService;
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
    public int insertBook(@RequestBody Book book) {
        return bookService.insertBook(book);
    }

    @PutMapping
    public int updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public int deleteBook(@PathVariable("id") int id) {
        return bookService.deleteBook(id);
    }

    @GetMapping("/{bookId}/borrowings")
    public List<Borrowing> getBorrowingsByBookId(@PathVariable("bookId") int bookId) {
        return borrowingService.getBorrowingsByBookId(bookId);
    }

}

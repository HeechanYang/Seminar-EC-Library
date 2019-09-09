package com.endlesscreation.spring.services;

import com.endlesscreation.spring.dtos.SimpleResponse;
import com.endlesscreation.spring.mappers.BookMapper;
import com.endlesscreation.spring.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookMapper bookMapper;

    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    public Book getBookById(int bookId) {
        return bookMapper.getBookById(bookId);
    }

    public List<Book> getBooksByName(String name) {
        return bookMapper.getBooksByName(name);
    }

    public SimpleResponse insertBook(Book book) {
        int result = bookMapper.insertBook(book);

        return result > 0 ? SimpleResponse.SUCCESS : SimpleResponse.FAIL;
    }

    public SimpleResponse updateBook(Book book) {
        int result = bookMapper.updateBook(book);

        return result > 0 ? SimpleResponse.SUCCESS : SimpleResponse.FAIL;
    }

    public SimpleResponse deleteBook(int bookId) {
        int result = bookMapper.deleteBook(bookId);

        return result > 0 ? SimpleResponse.SUCCESS : SimpleResponse.FAIL;
    }
}

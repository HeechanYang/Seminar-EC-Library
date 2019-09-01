package com.endlesscreation.spring.services;

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

    public List<Book> getAllBooks(){
        return bookMapper.getAllBooks();
    }

    public Book getBookById(int bookId){
        return bookMapper.getBookById(bookId);
    }

    public List<Book> getBooksByName(String name){
        return bookMapper.getBooksByName(name);
    }

    public int insertBook(Book book){
        return bookMapper.insertBook(book);
    }

    public int updateBook(Book book){
        return bookMapper.updateBook(book);
    }

    public int deleteBook(int bookId){
        return bookMapper.deleteBook(bookId);
    }
}

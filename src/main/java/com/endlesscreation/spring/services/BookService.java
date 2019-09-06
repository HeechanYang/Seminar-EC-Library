package com.endlesscreation.spring.services;

import com.endlesscreation.spring.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books;

    public BookService() {
        books = new ArrayList<>();
    }

    public List<Book> getAllBooks() {
        return this.books;
    }

    public Book getBookById(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                return books.get(i);
            }
        }

        return null;
    }

    public List<Book> getBooksByName(String name) {
        List<Book> result = new ArrayList<>();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().contains(name)) {
                result.add(books.get(i));
            }
        }

        return result;
    }

    public int insertBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                // 이미 존재하는 id면 -1 반환
                return -1;
            }
        }

        books.add(book);

        return books.size();
    }

    public int updateBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                books.get(i).setName(book.getName());
                books.get(i).setAuthor(book.getAuthor());
                // 업데이트 되었으면 index 반환
                return i;
            }
        }

        // 업데이트된 것이 없으면 0 반환
        return 0;
    }

    public int deleteBook(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                // 삭제 되었으면 index 반환
                return i;
            }
        }

        // 삭제된 것이 없으면 0 반환
        return 0;
    }

//    private final BookMapper bookMapper;
//
//    public BookService(BookMapper bookMapper) {
//        this.bookMapper = bookMapper;
//    }
//
//    public List<Book> getAllBooks(){
//        return bookMapper.getAllBooks();
//    }
//
//    public Book getBookById(int bookId){
//        return bookMapper.getBookById(bookId);
//    }
//
//    public List<Book> getBooksByName(String name){
//        return bookMapper.getBooksByName(name);
//    }
//
//    public int insertBook(Book book){
//        return bookMapper.insertBook(book);
//    }
//
//    public int updateBook(Book book){
//        return bookMapper.updateBook(book);
//    }
//
//    public int deleteBook(int bookId){
//        return bookMapper.deleteBook(bookId);
//    }
}

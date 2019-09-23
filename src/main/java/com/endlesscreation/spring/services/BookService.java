package com.endlesscreation.spring.services;

import com.endlesscreation.spring.dtos.SimpleResponse;
import com.endlesscreation.spring.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books;
    private int autoIncrementId;

    public BookService() {
        books = new ArrayList<>();
        this.autoIncrementId = 1;
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

    public SimpleResponse insertBook(Book book) {
        book.setId(autoIncrementId++);
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                // 이미 존재하는 id면 -1 반환
                return SimpleResponse.FAIL;
            }
        }

        books.add(book);

        return SimpleResponse.SUCCESS;
    }

    public SimpleResponse updateBook(int id, Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.get(i).setName(book.getName());
                books.get(i).setAuthor(book.getAuthor());
                // 업데이트 되었으면 index 반환
                return SimpleResponse.SUCCESS;
            }
        }

        // 업데이트된 것이 없으면 0 반환
        return SimpleResponse.NOTHING;
    }

    public SimpleResponse deleteBook(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                // 삭제 되었으면 index 반환
                return SimpleResponse.SUCCESS;
            }
        }

        // 삭제된 것이 없으면 0 반환
        return SimpleResponse.NOTHING;
    }
}

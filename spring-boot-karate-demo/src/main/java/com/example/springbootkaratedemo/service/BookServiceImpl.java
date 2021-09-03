package com.example.springbootkaratedemo.service;

import com.example.springbootkaratedemo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private List<Book> books;

    public BookServiceImpl() {
        initBooks();
    }

    private void initBooks() {
        books = new ArrayList<>();
        books.add(Book.builder().title("Clean Code").price(22.50).build());
        books.add(Book.builder().title("Clean Architecture").price(30.50).build());
        books.add(Book.builder().title("Spring in action").price(21.20).build());
    }

    @Override
    public List<Book> listAll() {
        return Collections.unmodifiableList(books);
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }
}

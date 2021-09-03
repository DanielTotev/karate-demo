package com.example.springbootkaratedemo.service;

import com.example.springbootkaratedemo.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    void addBook(Book book);
}

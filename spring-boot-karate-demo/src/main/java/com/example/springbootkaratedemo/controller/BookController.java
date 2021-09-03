package com.example.springbootkaratedemo.controller;

import com.example.springbootkaratedemo.exception.InvalidBookException;
import com.example.springbootkaratedemo.model.Book;
import com.example.springbootkaratedemo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> listAll() {
        return bookService.listAll();
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book) {
        if(book.getTitle().isBlank() || book.getPrice() < 0) {
            throw new InvalidBookException();
        }
        bookService.addBook(book);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @ExceptionHandler(InvalidBookException.class)
    private ResponseEntity<Book> handleInvalidBookException() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }
}

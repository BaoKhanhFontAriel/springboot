package com.example.restful_api.controller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.example.restful_api.dto.BookRequest;
import com.example.restful_api.model.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")

public class BookController {
    private ConcurrentHashMap<String, Book> books;

    public BookController() {
        books = new ConcurrentHashMap<>();
        books.put("OX_13", new Book("OX_13", "Gone with the wind", "Cuong", 1945));
        books.put("OX_14", new Book("OX_13", "Chi Dau", "Nam Cao", 1943));
    }

    @GetMapping
    public List<Book> getBooks() {
        return books.values().stream().toList();
    }

    @PostMapping
    public Book createNewBook(@RequestBody BookRequest bookRequest) {
        String uuid = UUID.randomUUID().toString();
        Book newBook =  new Book(uuid, bookRequest.title(), bookRequest.author(), bookRequest.year());
        books.put(uuid, newBook);
        return newBook;
    }
}

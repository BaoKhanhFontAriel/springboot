package com.example.restful_api.controller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.example.restful_api.dto.BookRequest;
import com.example.restful_api.model.Book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/books")

public class BookController {
    private ConcurrentHashMap<String, Book> books;

    public BookController() {
        books = new ConcurrentHashMap<>();
        books.put("OX_13", new Book("OX_13", "Gone with the wind", "Cuong", 1945));
        books.put("OX_14", new Book("OX_14", "Chi Dau", "Nam Cao", 1943));
    }

    @GetMapping
    public List<Book> getBooks() {
        return books.values().stream().toList();
    }

    @PostMapping
    public ResponseEntity<Book> createNewBook(@RequestBody BookRequest bookRequest) {
        String uuid = UUID.randomUUID().toString();
        Book newBook = new Book(uuid, bookRequest.title(), bookRequest.author(), bookRequest.year());
        books.put(uuid, newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @GetMapping(value = "/{id}")
    public Book getBookById(@PathVariable("id") String id) {
        Book book = books.get(id);
        if (book == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Book not found");
        }
        return book;
    }

    @PutMapping(value = "/{id}")
    public Book updateBookById(@PathVariable("id") String id, @RequestBody BookRequest bookRequest) {

        Book existedBook = books.get(id);
        if (existedBook == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Book not found");
        }
        existedBook.setTitle(bookRequest.title());
        existedBook.setAuthor(bookRequest.author());
        existedBook.setYear(bookRequest.year());
        return existedBook;
    }

    @DeleteMapping(value = "/{id}")
    public Book deleteBookById(@PathVariable("id") String id) {
        Book removedBook = books.remove(id);
        return removedBook;
    }
}

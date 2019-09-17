package com.bibliotheque.bookmicroservice.book.controller;

import com.bibliotheque.bookmicroservice.book.model.Book;

import com.bibliotheque.bookmicroservice.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/api/book/getAll")
    public  List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(value = "/api/book/getBook")
    public  Book getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @PostMapping(value="/api/book/addBook")
    public  Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @PutMapping(value="/api/book/updateBook")
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }

    @DeleteMapping(value="/api/book/deleteBook")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
}

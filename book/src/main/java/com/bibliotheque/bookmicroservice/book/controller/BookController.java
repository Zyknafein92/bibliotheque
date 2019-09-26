package com.bibliotheque.bookmicroservice.book.controller;

import com.bibliotheque.bookmicroservice.book.model.Book;

import com.bibliotheque.bookmicroservice.book.service.BookService;
import com.bibliotheque.bookmicroservice.book.service.dto.BookDTO;
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

    @RequestMapping(value = "/api/book/getBook", method = RequestMethod.GET)
    public Book getBook(@RequestParam(name = "id", defaultValue = "")  String id){
        return bookService.getBook(Long.valueOf(id));
    }


    @RequestMapping(value = "/api/book/addBook", method = RequestMethod.POST)
    public Book createBook(@RequestBody BookDTO bookDTO){
        return bookService.createBook(bookDTO);
    }

    @RequestMapping(value = "/api/book/updateBook", method = RequestMethod.PUT)
    public void updateBook(@RequestBody BookDTO bookDTO){
        bookService.updateBook(bookDTO);
    }

    @RequestMapping(value = "/api/book/deleteBook", method = RequestMethod.DELETE)
    public void deleteBook(@RequestParam(name = "id", defaultValue = "")  String id){
        bookService.deleteBook(Long.valueOf(id));
    }
}

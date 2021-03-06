package com.bibliotheque.bookmicroservice.book.controller;

import com.bibliotheque.bookmicroservice.book.model.Book;
import com.bibliotheque.bookmicroservice.book.service.BookService;
import com.bibliotheque.bookmicroservice.book.service.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/api/book/getAll")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.getBooks();
        if (books == null) return ResponseEntity.noContent().build();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/book/getBook", method = RequestMethod.GET)
    public ResponseEntity<Book> getBook(@RequestParam(name = "id", defaultValue = "") String id) {
        Book book = bookService.getBook(Long.valueOf(id));
        if (book == null) return ResponseEntity.noContent().build();
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/book/addBook", method = RequestMethod.POST)
    public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {
        Book bookToCreate = bookService.createBook(bookDTO);
        if (bookToCreate == null) return ResponseEntity.noContent().build();
        return new ResponseEntity<>(bookToCreate, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/book/updateBook", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateBook(@RequestBody BookDTO bookDTO) {
        bookService.updateBook(bookDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/book/deleteBook", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBook(@RequestParam(name = "id", defaultValue = "") String id) {
        Book book = bookService.getBook(Long.valueOf(id));
        if (book == null) return ResponseEntity.noContent().build();
        bookService.deleteBook(book.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

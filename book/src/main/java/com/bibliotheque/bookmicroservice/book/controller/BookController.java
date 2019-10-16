package com.bibliotheque.bookmicroservice.book.controller;

import com.bibliotheque.bookmicroservice.book.exceptions.BookCreationException;
import com.bibliotheque.bookmicroservice.book.model.Book;

import com.bibliotheque.bookmicroservice.book.service.BookService;
import com.bibliotheque.bookmicroservice.book.service.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Book> getBook(@RequestParam(name = "id", defaultValue = "")  String id){
        Book book = bookService.getBook(Long.valueOf(id));

        if(book == null) return ResponseEntity.noContent().build();

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/api/book/addBook", method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody BookDTO bookDTO) { // retour en object renvois soit l'erreur
        Book bookToCreate = bookService.createBook(bookDTO);

        if (bookToCreate == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bookToCreate.getId())
                .toUri();

        return ResponseEntity.created(location).build();
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

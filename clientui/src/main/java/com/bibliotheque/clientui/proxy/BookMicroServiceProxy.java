package com.bibliotheque.clientui.proxy;

import com.bibliotheque.clientui.model.Book;
import com.bibliotheque.clientui.model.dto.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "com.bibliotheque.bookmicroservice", url = "localhost:9010")
public interface BookMicroServiceProxy {

    @GetMapping(value = "/api/book/getAll")
    List<Book> getBooks();

    @RequestMapping(value = "/api/book/getBook", method = RequestMethod.GET)
    ResponseEntity<Book> getBook(@RequestParam(name = "id", defaultValue = "")  String id);

    @RequestMapping(value = "/api/book/addBook", method = RequestMethod.POST)
    ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO);

    @RequestMapping(value = "/api/book/updateBook", method = RequestMethod.PUT) // TODO: Implémenter DTO
    ResponseEntity<Void> updateBook(@RequestBody BookDTO bookDTO);

    @RequestMapping(value = "/api/book/deleteBook", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteBook(@RequestParam(name = "id", defaultValue = "")  String id);
}

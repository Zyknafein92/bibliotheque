package com.bibliotheque.bookmicroservice.book.service;

import com.bibliotheque.bookmicroservice.book.model.Book;
import com.bibliotheque.bookmicroservice.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    Book getBook(Long id);

    Book createBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);


}

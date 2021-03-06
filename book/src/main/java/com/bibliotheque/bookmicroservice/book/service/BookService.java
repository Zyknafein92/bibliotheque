package com.bibliotheque.bookmicroservice.book.service;

import com.bibliotheque.bookmicroservice.book.exceptions.BookCreationException;
import com.bibliotheque.bookmicroservice.book.model.Book;
import com.bibliotheque.bookmicroservice.book.service.dto.BookDTO;


import java.util.List;


public interface BookService {

    List<Book> getBooks();

    Book getBook(Long id);

    Book createBook(BookDTO bookDTO) throws BookCreationException;

    void updateBook(BookDTO bookDTO);

    void deleteBook(long id);


}

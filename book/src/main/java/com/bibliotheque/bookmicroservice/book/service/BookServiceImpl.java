package com.bibliotheque.bookmicroservice.book.service;

import com.bibliotheque.bookmicroservice.book.model.Book;
import com.bibliotheque.bookmicroservice.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.existsById(id);
    }
}

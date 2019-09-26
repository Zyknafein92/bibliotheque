package com.bibliotheque.bookmicroservice.book.service;

import com.bibliotheque.bookmicroservice.book.exceptions.BookNotFoundException;
import com.bibliotheque.bookmicroservice.book.model.Book;
import com.bibliotheque.bookmicroservice.book.repository.BookRepository;
import com.bibliotheque.bookmicroservice.book.service.dto.BookDTO;
import com.bibliotheque.bookmicroservice.book.service.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        Book book = bookRepository.getOne(id);
        if(book == null) throw new BookNotFoundException("Le livre recherché n'a pas été trouvé");
        return book;
    }

    @Override
    public Book createBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDtoToBook(bookDTO);
        return bookRepository.save(book);
    }

    @Override
    public void updateBook(BookDTO bookDTO) {
        Book book = getBook(bookDTO.getId());
        bookMapper.updateBookFromBookDTO(bookDTO,book);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }
}

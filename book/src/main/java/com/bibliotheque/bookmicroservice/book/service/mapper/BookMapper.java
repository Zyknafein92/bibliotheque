package com.bibliotheque.bookmicroservice.book.service.mapper;

import com.bibliotheque.bookmicroservice.book.model.Book;
import com.bibliotheque.bookmicroservice.book.service.dto.BookDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BookMapper {

    BookDTO bookToBookDTO(Book book);

    Book bookDtoToBook(BookDTO bookDTO);
}

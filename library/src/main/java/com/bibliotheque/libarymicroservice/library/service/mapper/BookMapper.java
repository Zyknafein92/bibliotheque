package com.bibliotheque.libarymicroservice.library.service.mapper;

import com.bibliotheque.libarymicroservice.library.model.Book;
import com.bibliotheque.libarymicroservice.library.service.dto.BookDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BookMapper {

    BookDTO bookToBookDTO(Book book);

    Book bookDtoToBook(BookDTO bookDTO);
}

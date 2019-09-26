package com.bibliotheque.libarymicroservice.library.service.mapper;

import com.bibliotheque.libarymicroservice.library.model.Library;
import com.bibliotheque.libarymicroservice.library.service.dto.LibraryDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LibraryMapper {

    LibraryDTO librabyToLibraryDTO(Library libraby);
    Library librabyDtoToLibrary(LibraryDTO librabyDTO);
}

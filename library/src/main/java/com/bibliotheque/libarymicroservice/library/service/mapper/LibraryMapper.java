package com.bibliotheque.libarymicroservice.library.service.mapper;

import com.bibliotheque.libarymicroservice.library.model.Library;
import com.bibliotheque.libarymicroservice.library.service.dto.LibraryDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LibraryMapper {

    LibraryDTO librabyToLibraryDTO(Library library);
    Library librabyDtoToLibrary(LibraryDTO libraryDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void updateLibraryFromLibraryDTO(LibraryDTO libraryDTO, @MappingTarget Library library);
}

package com.bibliotheque.libarymicroservice.library.service;

import com.bibliotheque.libarymicroservice.library.exceptions.LibraryNotFoundException;
import com.bibliotheque.libarymicroservice.library.model.Library;
import com.bibliotheque.libarymicroservice.library.service.dto.LibraryDTO;

import java.util.List;

public interface LibraryService {

    List<Library> getLibrarys();

    Library getLibrary(Long id) throws LibraryNotFoundException;

    Library createLibrary(LibraryDTO libraryDTO);

    void updateLibrary(LibraryDTO libraryDTO);

    void deleteLibrary(Long id);

}

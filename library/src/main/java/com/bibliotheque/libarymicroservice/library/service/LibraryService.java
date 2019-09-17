package com.bibliotheque.libarymicroservice.library.service;

import com.bibliotheque.libarymicroservice.library.model.Library;

import java.util.List;

public interface LibraryService {

    List<Library> getLibrarys();

    Library getLibrary(Long id);

    Library createLibrary(Library library);

    void updateLibrary(Library library);

    void deleteLibrary(Long id);
}

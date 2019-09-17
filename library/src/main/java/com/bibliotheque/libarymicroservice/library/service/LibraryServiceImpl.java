package com.bibliotheque.libarymicroservice.library.service;

import com.bibliotheque.libarymicroservice.library.model.Library;
import com.bibliotheque.libarymicroservice.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public List<Library> getLibrarys() {
        return libraryRepository.findAll();
    }

    @Override
    public Library getLibrary(Long id) {
        return libraryRepository.getOne(id);
    }

    @Override
    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public void updateLibrary(Library library) {
        libraryRepository.save(library);
    }

    @Override
    public void deleteLibrary(Long id) {
        libraryRepository.deleteById(id);
    }
}

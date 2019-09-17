package com.bibliotheque.libarymicroservice.library.controller;

import com.bibliotheque.libarymicroservice.library.model.Library;
import com.bibliotheque.libarymicroservice.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping(value = "/api/library/getAll")
    public List<Library> getLibrarys() {
        return libraryService.getLibrarys();
    }

    @GetMapping(value = "/api/library/getLibrary")
    public  Library getLibrary(@PathVariable Long id){
        return libraryService.getLibrary(id);
    }

    @PostMapping(value="/api/library/addLibrary")
    public  Library createLibrary(@RequestBody Library library){
        return libraryService.createLibrary(library);
    }

    @PutMapping(value="/api/library/updateLibrary")
    public void updateLibrary(@RequestBody Library library){
        libraryService.updateLibrary(library);
    }

    @DeleteMapping(value="/api/library/deleteLibrary")
    public void deleteLibrary(@PathVariable Long id){
        libraryService.deleteLibrary(id);
    }
}

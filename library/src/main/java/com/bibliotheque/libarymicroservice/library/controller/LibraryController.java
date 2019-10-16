package com.bibliotheque.libarymicroservice.library.controller;

import com.bibliotheque.libarymicroservice.library.model.Library;
import com.bibliotheque.libarymicroservice.library.service.LibraryService;
import com.bibliotheque.libarymicroservice.library.service.dto.LibraryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
// todo : vérif sur les caractères ect... traitement erreur.
    @Autowired
    private LibraryService libraryService;

    @GetMapping(value = "/api/library/getAll")
    public List<Library> getLibrarys() {
        return libraryService.getLibrarys();
    }

    @RequestMapping(value = "/api/library/getLibrary", method = RequestMethod.GET)
    public  Library getLibrary(@RequestParam(name = "id", defaultValue = "")  String id){
        return libraryService.getLibrary(Long.valueOf(id));
    }

    @RequestMapping(value = "/api/library/addLibrary", method = RequestMethod.POST)
    public  Library createLibrary(@RequestBody LibraryDTO libraryDTO){
        return libraryService.createLibrary(libraryDTO);
    }

    @RequestMapping(value ="/api/library/updateLibrary", method = RequestMethod.PUT)
    public void updateLibrary(@RequestBody LibraryDTO libraryDTO){
        libraryService.updateLibrary(libraryDTO);
    }

    @RequestMapping(value = "/api/library/deleteLibrary", method = RequestMethod.DELETE)
    public void deleteLibrary(@RequestParam(name = "id", defaultValue = "")  String id){
        libraryService.deleteLibrary(Long.valueOf(id));
    }
}

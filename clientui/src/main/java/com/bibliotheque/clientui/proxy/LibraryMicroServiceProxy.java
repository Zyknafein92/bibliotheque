package com.bibliotheque.clientui.proxy;

import com.bibliotheque.clientui.model.Library;
import com.bibliotheque.clientui.model.dto.LibraryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "com.bibliotheque.libarymicroservice", url = "localhost:9030")
public interface LibraryMicroServiceProxy {

    @GetMapping(value = "/api/library/getAll")
    public List<Library> getLibrarys();

    @RequestMapping(value = "/api/library/getLibrary", method = RequestMethod.GET)
    public ResponseEntity<Library> getLibrary(@RequestParam(name = "id", defaultValue = "")  String id);

    @RequestMapping(value = "/api/library/addLibrary", method = RequestMethod.POST)
    public ResponseEntity<Library> createLibrary(@RequestBody LibraryDTO libraryDTO);

    @RequestMapping(value ="/api/library/updateLibrary", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateLibrary(@RequestBody LibraryDTO libraryDTO);

    @RequestMapping(value = "/api/library/deleteLibrary", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteLibrary(@RequestParam(name = "id", defaultValue = "")  String id);
}

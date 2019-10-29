package com.bibliotheque.borrowmicroservice.borrow.service.proxy;


import org.apache.tomcat.jni.Library;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "com.bibliotheque.libarymicroservice", url = "localhost:9030")
public interface LibraryMicroServiceProxy {
    //todo : fait pour éventuellement récupérer la bibliothèque et l'ajouter dans le borrow à voir a l'usage
    @RequestMapping(value = "/api/library/getLibrary", method = RequestMethod.GET)
    Library getLibrary(String id);
}

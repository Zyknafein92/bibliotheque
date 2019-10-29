package com.bibliotheque.borrowmicroservice.borrow.service.proxy;

import com.bibliotheque.borrowmicroservice.borrow.model.Book;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "com.bibliotheque.bookmicroservice", url = "localhost:9010")
public interface BookMicroServiceProxy {

    @RequestMapping(value = "/api/book/getBook", method = RequestMethod.GET)
    Book getBook(String id);

}

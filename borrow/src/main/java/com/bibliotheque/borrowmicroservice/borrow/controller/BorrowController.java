package com.bibliotheque.borrowmicroservice.borrow.controller;

import com.bibliotheque.borrowmicroservice.borrow.model.Book;
import com.bibliotheque.borrowmicroservice.borrow.model.Borrow;
import com.bibliotheque.borrowmicroservice.borrow.model.User;
import com.bibliotheque.borrowmicroservice.borrow.service.BorrowService;
import com.bibliotheque.borrowmicroservice.borrow.service.dto.BorrowDTO;
import com.bibliotheque.borrowmicroservice.borrow.service.proxy.BookMicroServiceProxy;
import com.bibliotheque.borrowmicroservice.borrow.service.proxy.UserMicroServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowController {

    @Autowired
    private BorrowService borrowService;
    @Autowired
    BookMicroServiceProxy bookMicroServiceProxy;
    @Autowired
    UserMicroServiceProxy userMicroServiceProxy;


    @GetMapping(value = "/api/borrow/getAll")
    public List<Borrow> findBorrowById(@PathVariable Long id) {
        return null;  // todo : implémenter la querry sql
    }

    @GetMapping(value = "/api/borrow/getBorrow")
    public Borrow getBorrow(@PathVariable Long id) {
        return borrowService.getBorrow(id);
    }

    @PostMapping(value="/api/borrow/addBorrow")
    public Borrow createBorrow(@RequestBody BorrowDTO borrowDTO, User user, Book book) {

        user = userMicroServiceProxy.getUser(user.getId());
        book = bookMicroServiceProxy.getBook(book.getId());

        return borrowService.createBorrow(borrowDTO, user, book);
    }

    @PutMapping(value="/api/borrow/extendBorrow")
    public Borrow extendBorrow(@PathVariable Long id) {
        return borrowService.extendBorrow(id);
    }

    @PutMapping(value="/api/borrow/updateBorrow")
    public void updateBorrow(@RequestBody BorrowDTO borrowDTO) {
        borrowService.updateBorrow(borrowDTO);
    }

    @DeleteMapping(value="/api/borrow/deleteBorrow")
    public void deleteBorrow(@PathVariable Long id) {
        borrowService.deleteBorrow(id);
    }
}

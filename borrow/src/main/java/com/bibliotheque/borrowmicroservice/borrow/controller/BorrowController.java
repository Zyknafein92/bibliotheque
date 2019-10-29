package com.bibliotheque.borrowmicroservice.borrow.controller;

import com.bibliotheque.borrowmicroservice.borrow.model.Book;
import com.bibliotheque.borrowmicroservice.borrow.model.Borrow;
import com.bibliotheque.borrowmicroservice.borrow.model.User;
import com.bibliotheque.borrowmicroservice.borrow.service.BorrowService;
import com.bibliotheque.borrowmicroservice.borrow.service.dto.BorrowDTO;
import com.bibliotheque.borrowmicroservice.borrow.service.proxy.BookMicroServiceProxy;
import com.bibliotheque.borrowmicroservice.borrow.service.proxy.UserMicroServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Borrow> getBorrow(@RequestParam(name = "id", defaultValue = "")  String id) {
        Borrow borrow = borrowService.getBorrow(Long.valueOf(id));
        if(borrow == null) return ResponseEntity.noContent().build();
        return new ResponseEntity<>(borrow, HttpStatus.OK);
    }

    @PostMapping(value="/api/borrow/addBorrow")
    public ResponseEntity<Borrow> createBorrow(@RequestBody BorrowDTO borrowDTO, User user, Book book) {
        user = userMicroServiceProxy.getUser(user.getId());
        book = bookMicroServiceProxy.getBook(book.getId());
        Borrow borrow = borrowService.createBorrow(borrowDTO, user, book);
        return new ResponseEntity<>(borrow,HttpStatus.OK);
    }

    @PutMapping(value="/api/borrow/extendBorrow")
    public ResponseEntity<Borrow> extendBorrow(@RequestParam(name = "id", defaultValue = "")  String id) {
        Borrow borrow = borrowService.extendBorrow(Long.valueOf(id));
        if(borrow == null) return ResponseEntity.noContent().build();
        return new ResponseEntity<>(borrow, HttpStatus.OK);
    }

    @PutMapping(value="/api/borrow/updateBorrow")
    public ResponseEntity<Void> updateBorrow(@RequestBody BorrowDTO borrowDTO) {
        borrowService.updateBorrow(borrowDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value="/api/borrow/deleteBorrow")
    public ResponseEntity<Void> deleteBorrow(@RequestParam(name = "id", defaultValue = "")  String id) {
        Borrow borrow = borrowService.getBorrow(Long.valueOf(id));
        if(borrow == null) return ResponseEntity.noContent().build();
        borrowService.deleteBorrow(borrow.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.bibliotheque.borrowmicroservice.borrow.controller;

import com.bibliotheque.borrowmicroservice.borrow.model.Borrow;
import com.bibliotheque.borrowmicroservice.borrow.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @GetMapping(value = "/api/borrow/getAll")
    public List<Borrow> findBorrowById(@PathVariable Long id) {
        return null;  // todo : implémenter la querry sql
    }

    @GetMapping(value = "/api/borrow/getBorrow")
    public Borrow getBorrow(@PathVariable Long id) {
        return borrowService.getBorrow(id);
    }

    @PostMapping(value="/api/borrow/addBorrow")
    public Borrow createBorrow(@RequestBody Borrow borrow) {
        return borrowService.createBorrow(borrow);
    }

    @PutMapping(value="/api/borrow/extendBorrow")
    public Borrow extendBorrow(@PathVariable Long id) {
        return borrowService.extendBorrow(id);
    }

    @PutMapping(value="/api/borrow/updateBorrow")
    public void updateBorrow(@RequestBody Borrow borrow) {
        borrowService.updateBorrow(borrow);
    }

    @DeleteMapping(value="/api/borrow/deleteBorrow")
    public void deleteBorrow(@PathVariable Long id) {
        borrowService.deleteBorrow(id);
    }
}

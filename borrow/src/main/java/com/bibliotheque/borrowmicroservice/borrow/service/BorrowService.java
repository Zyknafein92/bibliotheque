package com.bibliotheque.borrowmicroservice.borrow.service;

import com.bibliotheque.borrowmicroservice.borrow.model.Book;
import com.bibliotheque.borrowmicroservice.borrow.model.Borrow;
import com.bibliotheque.borrowmicroservice.borrow.model.User;
import com.bibliotheque.borrowmicroservice.borrow.service.dto.BorrowDTO;

import java.util.List;

public interface BorrowService {

    List<Borrow> findBorrowById(Long id);

    Borrow getBorrow(Long id);

    Borrow createBorrow(BorrowDTO borrowDTO, User user, Book book);

    Borrow extendBorrow(Long id);

    void updateBorrow(BorrowDTO borrowDTO);

    void deleteBorrow(Long id);
}

package com.bibliotheque.borrowmicroservice.borrow.service;

import com.bibliotheque.borrowmicroservice.borrow.model.Borrow;

import java.util.List;

public interface BorrowService {

    List<Borrow> findBorrowById(Long id);

    Borrow getBorrow(Long id);

    Borrow createBorrow(Borrow borrow);

    Borrow extendBorrow(Long id);

    void updateBorrow(Borrow borrow);

    void deleteBorrow(Long id);
}

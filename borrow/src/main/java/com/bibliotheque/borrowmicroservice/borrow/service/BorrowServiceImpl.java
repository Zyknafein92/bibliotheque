package com.bibliotheque.borrowmicroservice.borrow.service;

import com.bibliotheque.borrowmicroservice.borrow.model.Borrow;
import com.bibliotheque.borrowmicroservice.borrow.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    BorrowRepository borrowRepository;

    @Override
    public List<Borrow> findBorrowById(Long id) {
        return null;  // todo : implémenter la querry sql
    }

    @Override
    public Borrow getBorrow(Long id) {
        return borrowRepository.getOne(id);
    }

    @Override
    public Borrow createBorrow(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    @Override
    public Borrow extendBorrow(Long id) {
        Borrow borrow = getBorrow(id);
        return borrowRepository.save(borrow);
    }

    @Override
    public void updateBorrow(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    @Override
    public void deleteBorrow(Long id) {
        borrowRepository.deleteById(id);
    }
}

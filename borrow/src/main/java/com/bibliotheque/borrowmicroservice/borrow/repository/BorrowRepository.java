package com.bibliotheque.borrowmicroservice.borrow.repository;

import com.bibliotheque.borrowmicroservice.borrow.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Long> {
}

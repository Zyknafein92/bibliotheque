package com.bibliotheque.bookmicroservice.book.repository;

import com.bibliotheque.bookmicroservice.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}

package com.bibliotheque.libarymicroservice.library.repository;

import com.bibliotheque.libarymicroservice.library.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
}

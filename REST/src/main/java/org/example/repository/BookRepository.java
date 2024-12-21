package org.example.repository;

import org.example.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {
//    List<Books> findByAuthorId(Long authorId);
}
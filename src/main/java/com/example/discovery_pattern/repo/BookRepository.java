package com.example.discovery_pattern.repo;

import com.example.discovery_pattern.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByIsbn(String isbn);

    List<Book> findBooksByPublishYear(int publishYear);
    List<Book> findBooksByAuthor(String author);

}

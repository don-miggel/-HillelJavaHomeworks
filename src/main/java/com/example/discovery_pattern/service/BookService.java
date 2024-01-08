package com.example.discovery_pattern.service;

import com.example.discovery_pattern.entity.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book newBook);

    Book findBookById(Long id);
    Book findBookByIsbn(String isbn);

    List<Book> getAllBooks();

    List<Book> findBooksByAuthor(String author);

    Book updBook(Long id, Book book);

    String deleteBook(Long id);

}

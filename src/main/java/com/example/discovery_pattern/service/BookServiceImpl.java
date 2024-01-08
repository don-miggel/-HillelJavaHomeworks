package com.example.discovery_pattern.service;

import com.example.discovery_pattern.entity.Book;
import com.example.discovery_pattern.repo.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Book with id: "+id+" is ont found!"));
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author);
    }

    @Override
    public Book updBook(Long id, Book book) {
        Book bookToUpd = findBookById(id);
        bookToUpd.setBookName(book.getBookName());
        bookToUpd.setIsbn(book.getIsbn());
        bookToUpd.setAuthor(book.getAuthor());
        bookToUpd.setPublishYear(book.getPublishYear());
        return bookRepository.save(bookToUpd);
    }

    @Override
    public String deleteBook(Long id) {
        Book bookToDel = findBookById(id);
        bookRepository.delete(bookToDel);
        return "Book with id: "+ id+ " has been deleted !";
    }
}

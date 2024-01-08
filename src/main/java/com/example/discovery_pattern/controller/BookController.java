package com.example.discovery_pattern.controller;

import com.example.discovery_pattern.entity.Book;
import com.example.discovery_pattern.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks(){
        return  bookService.getAllBooks();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @GetMapping("/isbn/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public Book findBookByIsbn(@PathVariable String isbn){
        return bookService.findBookByIsbn(isbn);
    }

    @GetMapping("/auth/{author}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findByAuthor(@PathVariable String author){
        return bookService.findBooksByAuthor(author);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updBook(@RequestBody Book book, @PathVariable Long id){
        return bookService.updBook(id, book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }
}

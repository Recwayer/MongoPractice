package com.example.mongopractice.controllers;

import com.example.mongopractice.models.Author;
import com.example.mongopractice.models.Book;
import com.example.mongopractice.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getAll();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable String id) {
        return bookService.get(id);
    }

    @PostMapping("/book")
    public Book createBook(@RequestParam Book book) {
        return bookService.create(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.delete(id);
    }

    @DeleteMapping("/books")
    public void deleteAllBook() {
        bookService.deleteAll();
    }

    @PutMapping("/book")
    public void updateBook(@RequestParam Book book) {
        bookService.update(book);
    }

    @DeleteMapping("book/{id}/author/{name}")
    public void deleteAuthor(@PathVariable String id, @PathVariable String name) {
        Book book = bookService.get(id);
        List<Author> list = book.getAuthors();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                list.remove(list.get(i));
            }
        }
        bookService.create(book);
    }
}

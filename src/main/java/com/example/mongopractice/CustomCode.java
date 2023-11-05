package com.example.mongopractice;

import com.example.mongopractice.models.Book;
import com.example.mongopractice.services.impl.BookServiceImpl;
import com.example.mongopractice.services.impl.ReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomCode implements CommandLineRunner {
    private final BookServiceImpl bookService;
    private final ReaderServiceImpl readerService;

    @Autowired
    public CustomCode(BookServiceImpl bookService, ReaderServiceImpl readerService) {
        this.bookService = bookService;
        this.readerService = readerService;
    }

    @Override
    public void run(String... args) {
        List<Book> books = bookService.getAll();
        books.forEach(System.out::println);
        System.out.println(readerService.getAverageBooksRead());
    }
}

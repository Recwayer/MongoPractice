package com.example.mongopractice;

import com.example.mongopractice.models.Book;
import com.example.mongopractice.models.Reader;
import com.example.mongopractice.models.factories.BookFactory;
import com.example.mongopractice.models.factories.ReaderFactory;
import com.example.mongopractice.services.impl.BookServiceImpl;
import com.example.mongopractice.services.impl.ReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Init implements CommandLineRunner {
    private final BookServiceImpl booksService;
    private final ReaderServiceImpl readerService;

    private final BookFactory bookFactory;
    private final ReaderFactory readerFactory;

    @Autowired
    public Init(BookServiceImpl booksService, ReaderServiceImpl readerService, BookFactory bookFactory, ReaderFactory readerFactory) {
        this.booksService = booksService;
        this.readerService = readerService;
        this.bookFactory = bookFactory;
        this.readerFactory = readerFactory;
    }

    @Override
    public void run(String... args) {
//        List<Book> books =
//                bookFactory.listBuilder().books(100, 100);
//        booksService.saveAll(books);
//        List<Reader> readers = readerFactory.listBuilder().readers(100, 100);
//        readerService.saveAll(readers);
    }
}

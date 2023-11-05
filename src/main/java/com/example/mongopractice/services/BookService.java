package com.example.mongopractice.services;

import com.example.mongopractice.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    Book create(Book book);

    Book update(Book book);

    Book get(String id);

    void delete(String id);

    void deleteAll();

    void saveAll(List<Book> books);

    Page<Book> getMany(Pageable pageable);

    List<Book> getAll();

    double getAveragePageCount();
}

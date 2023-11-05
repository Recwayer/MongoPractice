package com.example.mongopractice.services.impl;

import com.example.mongopractice.exceptions.ClientErrorException;
import com.example.mongopractice.models.Book;
import com.example.mongopractice.repositories.BookRepository;
import com.example.mongopractice.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepo;

    @Autowired
    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book create(Book entity) {
        return bookRepo.save(entity);
    }

    @Override
    public Book update(Book entity) {
        return bookRepo.save(entity);
    }

    @Override
    public Book get(String id) {
        return bookRepo.findById(id).orElseThrow(() -> new ClientErrorException.NotFoundException("Книга с id=[%s] не найдена", id));
    }

    @Override
    public void delete(String id) {
        bookRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        bookRepo.deleteAll();

    }

    @Override
    public void saveAll(List<Book> entities) {
        bookRepo.saveAll(entities);
    }

    @Override
    public Page<Book> getMany(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    public double getAveragePageCount() {
        return bookRepo.findAveragePageCount();
    }
}

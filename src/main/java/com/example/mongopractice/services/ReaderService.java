package com.example.mongopractice.services;

import com.example.mongopractice.models.Reader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReaderService {
    Reader create(Reader reader);
    Reader update(Reader reader);

   Reader get(String id);

    void delete(String id);

    void deleteAll();

    void saveAll(List<Reader> books);

    Page<Reader> getMany(Pageable pageable);

    List<Reader> getAll();

    double getAverageBooksRead();
}

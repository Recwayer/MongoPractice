package com.example.mongopractice.services.impl;

import com.example.mongopractice.exceptions.ClientErrorException;
import com.example.mongopractice.models.Reader;
import com.example.mongopractice.repositories.ReaderRepository;
import com.example.mongopractice.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    private final ReaderRepository readerRepo;
    @Autowired
    public ReaderServiceImpl(ReaderRepository readerRepo) {
        this.readerRepo = readerRepo;
    }

    @Override
    public Reader create(Reader entity) {
        return readerRepo.save(entity);
    }

    @Override
    public Reader update(Reader entity) {
        return readerRepo.save(entity);
    }

    @Override
    public Reader get(String id) {
        return readerRepo.findById(id).orElseThrow(() -> new ClientErrorException.NotFoundException("Читатель с id=[%s] не найден", id));
    }

    @Override
    public void delete(String id) {
        readerRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        readerRepo.deleteAll();
    }

    @Override
    public void saveAll(List<Reader> entities) {
        readerRepo.saveAll(entities);
    }

    @Override
    public Page<Reader> getMany(Pageable pageable) {
        return readerRepo.findAll(pageable);
    }

    @Override
    public List<Reader> getAll() {
        return readerRepo.findAll();
    }

    public double getAverageBooksRead() {
        return readerRepo.findAverageBooksRead();
    }
}

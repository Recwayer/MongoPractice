package com.example.mongopractice.controllers;

import com.example.mongopractice.models.Reader;
import com.example.mongopractice.services.ReaderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReaderController {
    private final ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/readers")
    public Iterable<Reader> getAllReader() {
        return readerService.getAll();
    }

    @GetMapping("/reader/{id}")
    public Reader getReader(@PathVariable String id) {
        return readerService.get(id);
    }

    @PostMapping("/reader")
    public Reader createReader(@RequestParam Reader reader) {
        return readerService.create(reader);
    }

    @DeleteMapping("/reader/{id}")
    public void deleteReader(@PathVariable String id) {
        readerService.delete(id);
    }

    @DeleteMapping("/readers")
    public void deleteAllReader() {
        readerService.deleteAll();
    }

    @PutMapping("/reader")
    public Reader updateReader(@RequestParam Reader reader) {
        return readerService.update(reader);
    }
}

package com.example.mongopractice.repositories;

import com.example.mongopractice.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface BookRepository extends MongoRepository<Book, String> {
    @Query(value = "{ pageCount: { $exists: true } }", fields = "{ 'pageCount': 1 }")
    Double findAveragePageCount();
}

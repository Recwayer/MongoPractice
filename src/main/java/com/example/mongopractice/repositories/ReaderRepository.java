package com.example.mongopractice.repositories;

import com.example.mongopractice.models.Reader;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReaderRepository extends MongoRepository<Reader, String> {
    @Aggregation(pipeline = {
            "{ $match: { booksRead: { $exists: true } } }",
            "{ $group: { _id: null, averageBooksRead: { $avg: '$booksRead' } } }"
    })
    Double findAverageBooksRead();
}

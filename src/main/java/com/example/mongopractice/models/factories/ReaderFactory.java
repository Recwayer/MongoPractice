package com.example.mongopractice.models.factories;

import com.example.mongopractice.models.Reader;
import com.example.mongopractice.models.enums.GenderType;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReaderFactory {
    private static AtomicInteger nextId = new AtomicInteger(1);
    private static AtomicLong nextEpochDay = new AtomicLong(
            LocalDate.of(2000, 1, 1).toEpochDay());
    private final Faker faker = new Faker();

    public String name() {
        return faker.name().name();
    }

    public Integer birthYear() {
        return faker.random().nextInt(1930, 2015);
    }

    public String favoriteGenre() {
        return faker.book().genre();
    }

    public Integer booksRead(){
        return faker.random().nextInt(3,20);
    }
    public GenderType gender(){
        int i = faker.random().nextInt(1,100);
        if(i>50){
            return GenderType.Male;
        } else{
            return GenderType.Female;
        }
    }

    public Reader make(UnaryOperator<Reader>... readers) {
        final Reader result = new Reader(name(),birthYear(),gender(),favoriteGenre(),booksRead());
        Stream.of(readers).forEach(v -> v.apply(result));
        return result;
    }

    public ReaderFactory.ReadersListDTOFactory listBuilder() {
        return new ReaderFactory.ReadersListDTOFactory();
    }

    public class ReadersListDTOFactory {
        public List<Reader> readers(int min, int max,
                                  UnaryOperator<Reader>... readers) {
            return IntStream.range(0,
                            faker.number().numberBetween(min, max))
                    .mapToObj(i -> ReaderFactory.this.make(readers))
                    .collect(Collectors.toList());
        }
    }
}

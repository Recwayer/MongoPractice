package com.example.mongopractice.models.factories;

import com.example.mongopractice.models.Author;
import com.example.mongopractice.models.Book;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BookFactory {
    private static AtomicInteger nextId = new AtomicInteger(1);
    private static AtomicLong nextEpochDay = new AtomicLong(
            LocalDate.of(2000, 1, 1).toEpochDay());
    private final Faker faker = new Faker();

    public String title() {
        return faker.book().title() + " " +
                faker.color().name();
    }

    public List<Author> authors() {
        List<Author> list = new ArrayList<>();
        list.add(new Author(faker.book().author(), faker.random().nextInt(1960, 1980), faker.random().nextInt(faker.random().nextInt(5, 20))));
        list.add(new Author(faker.book().author(), faker.random().nextInt(1960, 1980), faker.random().nextInt(faker.random().nextInt(5, 20))));
        return list;
    }

    public Integer publicationYear() {
        return faker.random().nextInt(1980, 2023);
    }

    public String genre() {
        return faker.book().genre();
    }

    public Integer pageCount() {
        return faker.random().nextInt(80, 200);
    }


    public Book make(UnaryOperator<Book>... books) {
        final Book result = new Book(title(),
                publicationYear(), genre(), pageCount(),authors());
        Stream.of(books).forEach(v -> v.apply(result));
        return result;
    }

    public BooksListDTOFactory listBuilder() {
        return new
                BooksListDTOFactory();
    }

    public class BooksListDTOFactory {
        public List<Book> books(int min, int max,
                                UnaryOperator<Book>... books) {
            return IntStream.range(0,
                            faker.number().numberBetween(min, max))
                    .mapToObj(i -> BookFactory.this.make(books))
                    .collect(Collectors.toList());
        }
    }
}



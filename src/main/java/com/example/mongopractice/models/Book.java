package com.example.mongopractice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "books")
public class Book {
    @Id
    private String id;
    @Field(name = "title")
    @Indexed(unique = true, sparse = true, direction =
            IndexDirection.ASCENDING)
    private String title;
    private int publicationYear;
    private String genre;
    private int pageCount;
    @Field(name = "authors")
    private List<Author> authors;

    protected Book() {
    }

    public Book(String title, int publicationYear, String genre, int pageCount) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.pageCount = pageCount;
        this.authors = new ArrayList<>();
    }

    public Book(String title, int publicationYear, String genre, int pageCount, List<Author> authors) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.pageCount = pageCount;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", genre='" + genre + '\'' +
                ", pageCount=" + pageCount +
                ", authors=" + authors +
                '}';
    }
}

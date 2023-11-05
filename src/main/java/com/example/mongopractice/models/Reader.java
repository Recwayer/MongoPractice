package com.example.mongopractice.models;

import com.example.mongopractice.models.enums.GenderType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "readers")
public class Reader {
    @Id
    private String id;
    @Field(name = "name")
    @Indexed(unique = true, sparse = true, direction =
            IndexDirection.ASCENDING)
    private String name;
    private int birthYear;
    private GenderType gender;
    private String favoriteGenre;
    private int booksRead;

    public Reader(String name, int birthYear, GenderType gender, String favoriteGenre, int booksRead) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.favoriteGenre = favoriteGenre;
        this.booksRead = booksRead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String getFavoriteGenre() {
        return favoriteGenre;
    }

    public void setFavoriteGenre(String favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }

    public int getBookRead() {
        return booksRead;
    }

    public void setBookRead(int booksRead) {
        this.booksRead = booksRead;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", gender='" + gender + '\'' +
                ", favoriteGenre='" + favoriteGenre + '\'' +
                ", bookRead=" + booksRead +
                '}';
    }
}

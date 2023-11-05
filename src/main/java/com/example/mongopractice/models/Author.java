package com.example.mongopractice.models;

public class Author {
    private String name;
    private Integer birthYear;
    private Integer booksWritten;

    public Author(String name, Integer birthYear, Integer booksWritten) {
        this.name = name;
        this.birthYear = birthYear;
        this.booksWritten = booksWritten;
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

    public int getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(int booksWritten) {
        this.booksWritten = booksWritten;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", booksWritten=" + booksWritten +
                '}';
    }
}

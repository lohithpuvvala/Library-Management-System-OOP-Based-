package com.lohithpuvvala;

import java.util.List;

public class User {
    private int userId;
    private String name;
    List<Book> issuedBooks;

    public User(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void issueBook(Book book) {

    }

    public void returnBook(Book book) {

    }

    public void viewIssuedBooks() {

    }
}

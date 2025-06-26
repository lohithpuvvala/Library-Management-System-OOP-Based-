package com.lohithpuvvala;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int userId;            // Unique ID assigned to the user
    private String name;                 // Name of the user
    List<Book> issuedBooks;             // List of books currently issued to the user

    // Constructor initializes the user with ID and name
    public User(int id, String name) {
        this.userId = id;
        this.name = name;
        issuedBooks = new ArrayList<>();
    }

    // Returns user ID
    public int getUserId() {
        return userId;
    }

    // Returns user name
    public String getName() {
        return name;
    }

    // Adds a book to the list of issued books
    public void issueBook(Book book) {
        issuedBooks.add(book);
    }

    // Removes a book from the list of issued books
    public void returnBook(Book book) {
        issuedBooks.remove(book);
    }

    // Overrides toString() for displaying user details
    @Override
    public String toString() {
        return " Name: " + name + " - Id: " + userId + "\n IssuedBooks: " + issuedBooks;
    }
}

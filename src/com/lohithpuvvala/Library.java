package com.lohithpuvvala;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<User> users;
    private List<Book> books;

    public Library() {
        users = new ArrayList<>();
        books = new ArrayList<>();
    }

    public void addBook(Book book) {

    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void issueBookToUser(int bookId, int userId) {

    }

    public void returnBookFromUser(int bookId, int userId) {

    }

    public void displayAllBooks(){

    }

    public void displayAllUsers(){

    }
}

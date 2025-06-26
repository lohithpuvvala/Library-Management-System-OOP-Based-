package com.lohithpuvvala;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Library {
    private final List<User> users;
    private final List<Book> books;
    private static int bookId = 0;
    private static int userId = 0;

    public Library() {
        users = new ArrayList<>();
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        Book newBook = new Book(++bookId, title, author);
        books.add(newBook);
        System.out.println("=> Added:"+newBook.toString());
    }

    public void registerUser(String name) {
        User newUser = new User(++userId,name);
        users.add(newUser);
        System.out.println("=> New User Registered: "+newUser.toString());
    }

    public void issueBookToUser(int bookId, int userId) {

    }

    public void returnBookFromUser(int bookId, int userId) {

    }

    public void displayAllBooks(){
        for(Book book : books){
            System.out.println(book.toString());
        }
    }

    public void displayAllUsers(){
        for (User user : users){
            System.out.println(user.toString());
        }
    }
}

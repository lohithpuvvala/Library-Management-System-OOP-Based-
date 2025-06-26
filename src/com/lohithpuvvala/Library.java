package com.lohithpuvvala;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Library {
    private List<User> users;
    private List<Book> books;
    private static int bookId = 0;

    public Library() {
        users = new ArrayList<>();
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        Book newBook = new Book(++bookId, title, author);
        books.add(newBook);
        System.out.println("=> Added:"+newBook.toString());
    }

    public void registerUser(User user) {
        users.add(user);
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

    }
}

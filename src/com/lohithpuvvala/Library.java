package com.lohithpuvvala;

import java.util.HashMap;
import java.util.Map;

public class Library {
    // Stores userId mapped to User objects
    private final Map<Integer, User> users;

    // Stores bookId mapped to Book objects
    private final Map<Integer, Book> books;

    // Maps bookId to the userId who currently has it issued
    private final Map<Integer, Integer> issuedBookIdToUserId;

    // Auto-incrementing counters for unique IDs
    private static int bookId = 0;
    private static int userId = 0;

    // Constructor initializes the collections
    public Library() {
        users = new HashMap<>();
        books = new HashMap<>();
        issuedBookIdToUserId = new HashMap<>();
    }

    // Adds a new book to the library
    public void addBook(String title, String author) {
        Book newBook = new Book(++bookId, title, author);
        books.put(bookId, newBook);
        System.out.println("=> Added:" + newBook);
    }

    // Registers a new user to the library
    public void registerUser(String name) {
        User newUser = new User(++userId, name);
        users.put(userId, newUser);
        System.out.println("=> New User Registered: " + newUser);
    }

    // Issues a book to a user
    public void issueBookToUser(int bookId, int userId) {
        User user = users.get(userId);
        Book book = books.get(bookId);

        user.issueBook(book);              // Adds a book to user's issued list
        book.setIssued(true);              // Marks book as issued
        issuedBookIdToUserId.put(bookId, userId);  // Maps book to user

        System.out.println("=> Issued: " + book.getTitle() + " by " + book.getAuthor() +
                " (ID: " + book.getId() + ") Issued to " + user.getName() +
                " (ID: " + user.getUserId() + ")");
    }

    // Returns a book from a user
    public void returnBookFromUser(int bookId) {
        Book book = books.get(bookId);
        User user = users.get(issuedBookIdToUserId.get(bookId));

        user.returnBook(book);             // Removes book from user's issued list
        book.setIssued(false);             // Marks book as available
        issuedBookIdToUserId.remove(bookId);   // Unmaps book from user

        System.out.println("=> Return: " + book.getTitle() + " by " + book.getAuthor() +
                " (ID: " + book.getId() + ") Returned By " + user.getName() +
                " (ID: " + user.getUserId() + ")");
    }

    // Displays all books in the library
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println(" No books in the library...");
            return;
        }
        for (Book book : books.values()) {
            System.out.println(book.toString());
        }
    }

    // Displays all registered users in the library
    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println(" No users in the library...");
            return;
        }
        for (User user : users.values()) {
            System.out.println(user.toString());
        }
    }

    // Getters for access to internal data
    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public Map<Integer, Integer> getIssuedBookIdToUserId() {
        return issuedBookIdToUserId;
    }
}

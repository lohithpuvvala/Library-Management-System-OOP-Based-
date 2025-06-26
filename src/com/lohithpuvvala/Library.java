package com.lohithpuvvala;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<Integer,User> users;
    private final Map<Integer,Book> books;
    private final Map<Integer,Integer> issuedBookIdToUserId;
    private static int bookId = 0;
    private static int userId = 0;

    public Library() {
        users = new HashMap<>();
        books = new HashMap<>();
        issuedBookIdToUserId = new HashMap<>();
    }

    public void addBook(String title, String author) {
        Book newBook = new Book(++bookId, title, author);
        books.put(bookId,newBook);
        System.out.println("=> Added:"+ newBook);
    }

    public void registerUser(String name) {
        User newUser = new User(++userId,name);
        users.put(userId,newUser);
        System.out.println("=> New User Registered: "+ newUser);
    }

    public void issueBookToUser(int bookId, int userId) {
        User user = users.get(userId);
        Book book = books.get(bookId);

        user.issuedBooks.add(book);
        book.setIssued(true);
        issuedBookIdToUserId.put(bookId, userId);

        System.out.println("=> Issued: "+book.getTitle()+" by "+book.getAuthor()+" (ID: "+book.getId()+") Issued to "+user.getName()+" (ID: "+user.getUserId()+")");
    }

    public void returnBookFromUser(int bookId) {
        Book book = books.get(bookId);
        User user = users.get(issuedBookIdToUserId.get(bookId));

        user.issuedBooks.remove(book);
        book.setIssued(false);
        issuedBookIdToUserId.remove(bookId);

        System.out.println("=> Return: "+book.getTitle()+" by "+book.getAuthor()+" (ID: "+book.getId()+") Returned By "+user.getName()+" (ID: "+user.getUserId()+")");
    }

    public void displayAllBooks(){
        for(Book book : books.values()){
            System.out.println(book.toString());
        }
    }

    public void displayAllUsers(){
        for (User user : users.values()){
            System.out.println(user.toString());
        }
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }
}

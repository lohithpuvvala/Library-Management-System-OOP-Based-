package com.lohithpuvvala;

public class Book {
    private final int id;             // Unique identifier for the book
    private final String title;       // Title of the book
    private final String author;      // Author of the book
    private boolean isIssued;         // Flag indicating whether the book is issued

    // Constructor to initialize book details
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;        // By default, a new book is not issued
    }

    // Getter for book ID
    public int getId() {
        return id;
    }

    // Getter for book title
    public String getTitle() {
        return title;
    }

    // Getter for book author
    public String getAuthor() {
        return author;
    }

    // Checks if the book is issued
    public boolean isIssued() {
        return isIssued;
    }

    // Sets the issued status of the book
    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    // Overrides toString() to display book details
    @Override
    public String toString() {
        return " id:" + id + " -> " + title + " by " + author;
    }
}

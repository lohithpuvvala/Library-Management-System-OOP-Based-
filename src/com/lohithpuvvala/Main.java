package com.lohithpuvvala;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {

        // Preload sample books
        library.addBook("Clean Code", "Robert C. Martin");
        library.addBook( "Effective Java", "Joshua Bloch");
        library.addBook("Design Patterns", "Erich Gamma");
        library.addBook( "The Pragmatic Programmer", "Andrew Hunt");
        library.addBook( "Introduction to Algorithms", "Cormen et al.");

        // Preload sample users
        library.registerUser("Lohith Puvvala");
        library.registerUser("Aarav Mehta");
        library.registerUser("Sneha Reddy");
        library.registerUser("Rahul Sharma");
        library.registerUser("Priya Iyer");
        library.registerUser("Karthik Nair");
        library.registerUser("Ananya Verma");

        // Menu Loop Starts
        while (true) {
            System.out.println("\n====== Library Management Menu ======");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. View All Users");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = in.nextInt();
            in.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add a book to the Library
                    addBook();
                    break;
                case 2:
                    // Register user to the Library
                    registerUser();
                    break;
                case 3:
                    // Issue book logic
                    issueBook();
                    break;
                case 4:
                    // Return book logic
                    break;
                case 5:
                    displayAllBooks();
                    break;
                case 6:
                    displayAllUsers();
                    break;
                case 0:
                    System.out.println("=> Exiting.... Thank you!");
                    return;
                default:
                    System.out.println("=> Invalid choice.");
            }

            System.out.println("=> Do you want to exit the app? (Y/N)");
            String exit =  in.nextLine();
            if(exit.equalsIgnoreCase("y")){
                System.out.println("=> Exiting.... Thank you!");
                return;
            }
        }
    }

    static void addBook() {
        System.out.println("=== To Add a new Book ===");

        System.out.println("=> Enter Book Title: ");
        String bookTitle = in.nextLine();
        while(bookTitle.isBlank()) {
            System.out.println("=> Invalid Book Title. Please enter a valid Book Title: ");
            bookTitle = in.nextLine();
        }

        System.out.println("=> Enter Author Name: ");
        String bookAuthor = in.nextLine();
        while(bookAuthor.isBlank()) {
            System.out.println("=> Invalid Author Name. Please enter a valid Author Name: ");
            bookAuthor = in.nextLine();
        }

        System.out.println("=> Updating Book Details.....");
        library.addBook(bookTitle, bookAuthor);
        System.out.println("=> Successfully added Book to the Library");
    }

    static void registerUser() {
        System.out.println("=== To Register User ===");

        System.out.println("=> Enter User Name: ");
        String userName = in.nextLine();
        while(userName.isBlank()) {
            System.out.println("=> Invalid User Name. Please enter a valid User Name: ");
            userName = in.nextLine();
        }

        library.registerUser(userName);
        System.out.println("=> Successfully registered User");
    }

    static void issueBook() {
        System.out.println("=== To Issue Book ===");
        System.out.println("=> Enter Book Id: ");
        int bookId = in.nextInt();
        while(!library.getBooks().containsKey(bookId)) {
            System.out.println("Invalid Book Id. Please try again: ");
            bookId = in.nextInt();
        }
        if(library.getBooks().get(bookId).isIssued()) {
            System.out.println("Book already issued");
            return;
        }

        System.out.println("=> Enter User Id: ");
        int userId = in.nextInt();

        while(!library.getUsers().containsKey(userId)) {
            System.out.println("Invalid User Id, Please try again: ");
            userId = in.nextInt();
        }
        in.nextLine();
        library.issueBookToUser(userId, bookId);
        System.out.println("=> Successfully issued Book");
    }

    static void displayAllBooks() {
        System.out.println("=> Displaying All Books in the Library:");
        library.displayAllBooks();
    }

    static void displayAllUsers() {
        System.out.println("=> Displaying All Users in the Library:");
        library.displayAllUsers();
    }
}

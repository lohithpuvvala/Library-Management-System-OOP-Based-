package com.lohithpuvvala;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Library library = new Library();

        // Preload sample books
        library.addBook("Clean Code", "Robert C. Martin");
        library.addBook( "Effective Java", "Joshua Bloch");
        library.addBook("Design Patterns", "Erich Gamma");
        library.addBook( "The Pragmatic Programmer", "Andrew Hunt");
        library.addBook( "Introduction to Algorithms", "Cormen et al.");

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
                    // Add book logic
                    System.out.println("=== To Add a new Book ===");
                    System.out.println("=> Enter Book Title: ");
                    String bookTitle = in.nextLine();
                    System.out.println("=> Enter Author Name: ");
                    String bookAuthor = in.nextLine();
                    System.out.println("=> Updating Book Details.....");
                    library.addBook(bookTitle, bookAuthor);
                    System.out.println("=> Successfully added Book to the Library");
                    break;
                case 2:
                    // Register user logic
                    break;
                case 3:
                    // Issue book logic
                    break;
                case 4:
                    // Return book logic
                    break;
                case 5:
                    System.out.println("=> Displaying All Books in the Library:");
                    library.displayAllBooks();
                    break;
                case 6:
                    library.displayAllUsers();
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
}

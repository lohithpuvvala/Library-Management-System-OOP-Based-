package com.lohithpuvvala;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Preload sample books
        library.addBook(new Book(1, "Clean Code", "Robert C. Martin"));
        library.addBook(new Book(2, "Effective Java", "Joshua Bloch"));
        library.addBook(new Book(3, "Design Patterns", "Erich Gamma"));
        library.addBook(new Book(4, "The Pragmatic Programmer", "Andrew Hunt"));
        library.addBook(new Book(5, "Introduction to Algorithms", "Cormen et al."));

        // Menu Loop Starts
        while (true) {
            System.out.println("\n=== Library Management Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. View All Users");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add book logic
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
                    library.displayAllBooks();
                    break;
                case 6:
                    library.displayAllUsers();
                    break;
                case 0:
                    System.out.println("Exiting.... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

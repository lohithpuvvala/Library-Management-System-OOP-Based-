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
            System.out.println("7. User Details by Id");
            System.out.println("8. Check Book Availability");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = in.nextInt();
            in.nextLine(); // Consume newline

            //User Selected Operation is Performed
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
                    returnBook();
                    break;
                case 5:
                    //Displays all books in the Library
                    displayAllBooks();
                    break;
                case 6:
                    //Displays all users registered in the library
                    displayAllUsers();
                    break;
                case 7:
                    //User Details by ID
                    getUserDetailsById();
                    break;
                case 8:
                    //Checks Book Availability using ID
                    checkBookAvailability();
                    break;
                case 0:
                    //Exit message
                    System.out.println("=> Exiting.... Thank you!");
                    return;
                default:
                    System.out.println("=> Invalid choice.");
            }

            //Prompt user to exit the App
            System.out.println("=> Do you want to exit the app? (Y/N)");
            String exit =  in.nextLine();
            if(exit.equalsIgnoreCase("y")){
                System.out.println("=> Exiting.... Thank you!");
                return;
            }
        }
    }

    private static void checkBookAvailability() {
        System.out.println("=> Checking Book Availability");

        System.out.println("Enter Book Id: ");
        int bookId = in.nextInt();
        in.nextLine();// consume newline

        //checks if the book is already issued or not
        if(library.getIssuedBookIdToUserId().containsKey(bookId)){
            System.out.println("=> Book Id: " + bookId + " is already issued");
        }else {
            System.out.println("=> Book Id: " + bookId + " is available");
        }
    }

    static void addBook() {
        System.out.println("=== To Add a new Book ===");

        System.out.println("=> Enter Book Title: ");
        String bookTitle = in.nextLine();

        //Loops until Valid Book Title is Entered
        while(bookTitle.isBlank()) {
            System.out.println("=> Invalid Book Title. Please enter a valid Book Title: ");
            bookTitle = in.nextLine();
        }

        System.out.println("=> Enter Author Name: ");
        String bookAuthor = in.nextLine();
        //Loops until Valid input is Entered
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

        //Loops until Valid User Name is Entered
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
        //Loops until Valid BookId is Entered
        while(!library.getBooks().containsKey(bookId)) {
            System.out.println("Invalid Book Id. Please try again: ");
            bookId = in.nextInt();
        }

        //Checks if Book Already Issued or Not
        if(library.getBooks().get(bookId).isIssued()) {
            System.out.println("Book already issued");
            return;
        }

        System.out.println("=> Enter User Id: ");
        int userId = in.nextInt();

        //Loops until valid UserID is Entered
        while(!library.getUsers().containsKey(userId)) {
            System.out.println("Invalid User Id, Please try again: ");
            userId = in.nextInt();
        }
        in.nextLine();//consume newline

        library.issueBookToUser(bookId, userId);
        System.out.println("=> Successfully issued Book");
    }

    static void returnBook() {
        System.out.println("=== To Return Book ===");

        System.out.println("=> Enter Book Id: ");
        int bookId = in.nextInt();
        //Loops until valid BookID is Entered
        while(!library.getBooks().containsKey(bookId)) {
            System.out.println("Invalid Book Id. Please try again: ");
            bookId = in.nextInt();
        }

        //Checks if bookId is issued or not
        if(!library.getBooks().get(bookId).isIssued()) {
            System.out.println("Book has not been issued");
            return;
        }

        in.nextLine();
        library.returnBookFromUser(bookId);
    }

    static void displayAllBooks() {
        System.out.println("=> Displaying All Books in the Library:");
        library.displayAllBooks();
    }

    static void displayAllUsers() {
        System.out.println("=> Displaying All Users in the Library:");
        library.displayAllUsers();
    }

    static void getUserDetailsById() {
        System.out.println("=> Enter User Id: ");
        int userId = in.nextInt();
        //Loops until valid userID is entered.
        while(!library.getUsers().containsKey(userId)) {
            System.out.println("Invalid User Id, Please try again: ");
            userId = in.nextInt();
        }
        in.nextLine();//consume newline
        User user = library.getUsers().get(userId);
        System.out.println(user);
    }
}

package com;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int isbnno;
    private String bookName;
    private String author;

    public int getIsbnno() {
        return isbnno;
    }

    public void setIsbnno(int isbnno) {
        this.isbnno = isbnno;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class Library {
    private ArrayList<Book> bookList = new ArrayList<Book>();

    public void addBook(Book bobj) {
        bookList.add(bobj);
    }

    public boolean isEmpty() {
        return bookList.isEmpty();
    }

    public ArrayList<Book> viewAllBooks() {
        return bookList;
    }

    public ArrayList<Book> viewBooksByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<Book>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public int countnoofbook(String bname) {
        int count = 0;
        for (Book book : bookList) {
            if (book.getBookName().equalsIgnoreCase(bname)) {
                count++;
            }
        }
        return count;
    }
}

public class LibrarayManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n1. Add Book");
            System.out.println("2. Display book");
            System.out.println("3. Search Book");
            System.out.println("4. Count number of books");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    Book book = new Book();
                    System.out.print("\nEnter the isbn no: ");
                    book.setIsbnno(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Enter the book name: ");
                    book.setBookName(scanner.nextLine());
                    System.out.print("Enter the author name: ");
                    book.setAuthor(scanner.nextLine());

                    library.addBook(book);
                    break;
                case 2:
                    ArrayList<Book> allBooks = library.viewAllBooks();
                    if (allBooks.isEmpty()) {
                        System.out.println("\nThe list is empty");
                    } else {
                        System.out.println("\nBook details:");
                        for (Book b : allBooks) {
                            System.out.println("ISBN no: " + b.getIsbnno());
                            System.out.println("Book name: " + b.getBookName());
                            System.out.println("Author name: " + b.getAuthor());
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    System.out.print("\nEnter the author name: ");
                    String author = scanner.nextLine();
                    ArrayList<Book> booksByAuthor = library.viewBooksByAuthor(author);
                    if (booksByAuthor.isEmpty()) {
                        System.out.println("\nNone of the book published by the author " + author);
                    } else {
                        System.out.println("\nBooks written by " + author + ":");
                        for (Book b : booksByAuthor) {
                            System.out.println("ISBN no: " + b.getIsbnno());
                            System.out.println("Book name: " + b.getBookName());
                            System.out.println("Author name: " + b.getAuthor());
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    System.out.print("\nEnter the book name: ");
                    String bookName = scanner.nextLine();
                    int count = library.countnoofbook(bookName);
                    System.out.println("\nCount is " + count);
                    break;
                case 5:
                    System.out.println("\nExiting the program...");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
                    break;
            }
        } while (choice != 5);
    }
}
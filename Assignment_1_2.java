import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String ISBN;

    // Constructor
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    // Override toString for easy display
    @Override
    public String toString() {
        return "Book{Title='" + title + "', Author='" + author + "', ISBN='" + ISBN + "'}";
    }
}

class Library {
    private List<Book> collection;

    public Library() {
        this.collection = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(Book book) {
        collection.add(book);
        System.out.println(book.getTitle() + " added to the library.");
    }

    // Method to remove a book by ISBN
    public void removeBook(String ISBN) {
        for (Book book : collection) {
            if (book.getISBN().equals(ISBN)) {
                collection.remove(book);
                System.out.println(book.getTitle() + " removed from the library.");
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found.");
    }

    // Method to display all books
    public void displayBooks() {
        if (collection.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Library Collection:");
            for (Book book : collection) {
                System.out.println(book);
            }
        }
    }
}

// Main class to run the program
public class BookManager {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "12345");
        Book book2 = new Book("1984", "George Orwell", "67890");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", "11223");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Displaying books
        library.displayBooks();

        // Removing a book
        library.removeBook("67890");

        // Displaying books after removal
        library.displayBooks();
    }
}


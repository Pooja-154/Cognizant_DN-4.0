import java.util.*;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Java Basics", "John"),
            new Book(2, "Algorithms", "Robert"),
            new Book(3, "Data Structures", "Alice"),
            new Book(4, "Python Programming", "Bob")
        };

        System.out.println("Linear Search Result:");
        Book result1 = linearSearch(books, "Algorithms");
        System.out.println(result1 != null ? result1 : "Book not found");

        Arrays.sort(books, Comparator.comparing(b -> b.title));

        System.out.println("Binary Search Result:");
        Book result2 = binarySearch(books, "Algorithms");
        System.out.println(result2 != null ? result2 : "Book not found");
    }

    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(targetTitle)) {
                return b;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String targetTitle) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(targetTitle);
            if (cmp == 0)
                return books[mid];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }
}
class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "[Book ID: " + bookId + ", Title: " + title + ", Author: " + author + "]";
    }
}

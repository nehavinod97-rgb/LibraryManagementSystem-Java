package library;

public class Main {
    public static void main(String[] args) {
        System.out.println("✅ Library Management System Started\n");

        Library library = new Library();

        // Adding books
        Book b1 = new Book(1, "Java Programming", "James Gosling");
        Book b2 = new Book(2, "Python Basics", "Guido van Rossum");
        Book b3 = new Book(3, "Data Structures", "Robert Lafore");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        // Adding members
        Member m1 = new Member(101, "Neha Mishra");
        Member m2 = new Member(102, "Vinod Kumar");

        library.addMember(m1);
        library.addMember(m2);

        // Issuing books
        library.issueBook(1, 101);
        library.issueBook(2, 101);
        library.issueBook(3, 102);

        // Showing borrowed books
        m1.showBorrowedBooks();
        m2.showBorrowedBooks();

        // Returning a book
        library.returnBook(1, 101);

        // Show all books in the library
        library.showAllBooks();

        System.out.println("\n🏁 Program finished successfully!");
    }
}

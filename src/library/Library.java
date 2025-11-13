package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added: " + book.getTitle());
    }

    // Add a member
    public void addMember(Member member) {
        members.add(member);
        System.out.println("👤 Member added: " + member.getName());
    }

    // Issue a book
    public void issueBook(int bookId, int memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);

        if (book == null) {
            System.out.println("❌ Book not found!");
            return;
        }

        if (member == null) {
            System.out.println("❌ Member not found!");
            return;
        }

        if (book.isIssued()) {
            System.out.println("⚠️ Book already issued!");
        } else {
            book.issueBook();
            member.borrowBook(book);
            System.out.println("📚 Book '" + book.getTitle() + "' issued to " + member.getName());
        }
    }

    // Return a book
    public void returnBook(int bookId, int memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);

        if (book != null && member != null && book.isIssued()) {
            book.returnBook();
            member.returnBook(book);
            System.out.println("🔄 Book '" + book.getTitle() + "' returned by " + member.getName());
        } else {
            System.out.println("⚠️ Invalid return request.");
        }
    }

    // Display all books
    public void showAllBooks() {
        System.out.println("\n📘 Library Books:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // Helper methods
    private Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    private Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getMemberId() == id) return m;
        }
        return null;
    }
}

package Mini_projects.library;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Library {
    private List<Book> books;
    private List<User> users;
    private List<Transaction> transactions;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void checkoutBook(Book book, User user) {
        if (book.isAvailable() && books.contains(book) && users.contains(user)) {
            Transaction transaction = new Transaction(book, user);
            transactions.add(transaction);
            book.setAvailable(false);
            System.out.println(book.getTitle() + " checked out by " + user.getName());
        } else {
            System.out.println("Book unavailable or user not found. Unable to complete the transaction.");
        }
    }

    public void returnBook(Book book, User user) {
        if (!book.isAvailable() && books.contains(book) && users.contains(user)) {
            book.setAvailable(true);
            System.out.println(book.getTitle() + " returned by " + user.getName());
        } else {
            System.out.println("Invalid return operation. Book not borrowed by the user or book/user not found.");
        }
    }
}
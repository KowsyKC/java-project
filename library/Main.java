package Mini_projects.library;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        User user1 = new User("Alice", 1);
        User user2 = new User("Bob", 2);

        Librarian librarian = new Librarian("Eva", 3);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addUser(user1);
        library.addUser(user2);

        library.checkoutBook(book1, user1);
        library.checkoutBook(book2, user2);
        library.checkoutBook(book2, user1); // This transaction will fail as the book is already checked out

        library.returnBook(book1, user1);
        library.returnBook(book2, user2);
        library.returnBook(book2, user1); // This return operation will fail as the book is already available
    }
}


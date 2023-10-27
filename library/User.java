package Mini_projects.library;


class User {
    private String name;
    private int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }
}

class Librarian extends User {
    public Librarian(String name, int userId) {
        super(name, userId);
    }
}


class Transaction {
    private Book book;
    private User user;

    public Transaction(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }
}
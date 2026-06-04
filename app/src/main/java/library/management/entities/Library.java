package library.management.entities;

import java.util.List;

public class Library {

    private List<Book> books;
    private List<Member> members;
    private List<Transaction> transactions;

    public Library() {
    }

    public Library(List<Book> books, List<Member> members, List<Transaction> transactions) {
        this.books = books;
        this.members = members;
        this.transactions = transactions;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}

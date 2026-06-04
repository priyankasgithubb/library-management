package library.management.entities;

public class Book {

    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookCategory;
    private Integer bookQuantity;

    public Book() {
    }

    public Book(String bookId, String bookTitle, String bookAuthor,
                String bookCategory, Integer bookQuantity) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
        this.bookQuantity = bookQuantity;
    }

    public String getBookInfo() {
        return String.format(
                "Book ID: %s of title %s from the author %s of the category %s has %s quantity in the library",
                bookId, bookTitle, bookAuthor, bookCategory, bookQuantity);
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }
}
package library.management.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import library.management.entities.Book;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class BookServices {
    private List<Book> bookList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String BOOK_DB_PATH = "src/main/java/library/management/localDB/books.json";

    public BookServices() throws IOException {

        File books = new File(BOOK_DB_PATH);

        bookList = objectMapper.readValue(books, new TypeReference<List<Book>>() {});
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    public void addBook(Book newBook) {
        Optional<Book> existingBook = bookList.stream().filter(book -> book.getBookId().equalsIgnoreCase(newBook.getBookId())).findFirst();

        if (existingBook.isPresent()) {
            updateBook(newBook);
        } else {
            bookList.add(newBook);
            saveBooKListToFile();
        }
    }

    private void saveBooKListToFile() {
        try {

            objectMapper.writeValue(
                    new File(BOOK_DB_PATH),
                    bookList
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void updateBook(Book updatedBook){

        OptionalInt index = IntStream.range(0, bookList.size()).filter(i-> bookList.get(i).getBookId().equalsIgnoreCase(updatedBook.getBookId())).findFirst();

        if(index.isPresent()){
            bookList.set(index.getAsInt(),updatedBook);
            saveBooKListToFile();
        }
    }

    public List<Book> searchBookByTitle(String title){

        return bookList.stream().filter(book -> book.getBookTitle().toLowerCase().contains((title.toLowerCase()))).toList();

    }
}

package library.management.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import library.management.entities.Book;
import library.management.entities.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TransactionServices {
    private List<Book> bookList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String TRANSACTION_DB_PATH = "src/main/java/library/management/localDB/transactions.json";
    private List<Transaction> transactionList;

    public TransactionServices() throws IOException {

        File transactions =
                new File(TRANSACTION_DB_PATH);

        transactionList =
                objectMapper.readValue(
                        transactions,
                        new TypeReference<List<Transaction>>() {}
                );
    }

    public void addTransaction(Transaction transaction){

        transactionList.add(transaction);

        saveTransactionListToFile();
    }

    public void addTransactions(Transaction transaction){

        transactionList.add(transaction);

        saveTransactionListToFile();
    }

    public List<Transaction> getTransactionsByBook(String bookId){

        return transactionList.stream()
                .filter(transaction ->
                        transaction.getBookId()
                                .equalsIgnoreCase(bookId))
                .toList();
    }

    private void saveTransactionListToFile(){

        try{

            objectMapper.writeValue(
                    new File(TRANSACTION_DB_PATH),
                    transactionList
            );

        }catch(IOException e){

            e.printStackTrace();
        }
    }

}

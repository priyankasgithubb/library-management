package library.management.entities;

import java.util.Date;

public class Transaction {

    private String transactionId;
    private String memberId;
    private String bookId;
    private Date issueDate;
    private Date dueDate;
    private Date returnDate;
    private Integer fineAmount;

    public Transaction() {
    }

    public Transaction(String transactionId, String memberId, String bookId,
                       Date issueDate, Date dueDate, Date returnDate,
                       Integer fineAmount) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.fineAmount = fineAmount;
    }

    public String getTransactionInfo() {
        return String.format(
                "Transaction ID: %s, Member ID: %s, Book ID: %s, Issue Date: %s, Due Date: %s, Return Date: %s, Fine Amount: %d",
                transactionId, memberId, bookId, issueDate, dueDate, returnDate, fineAmount
        );
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Integer fineAmount) {
        this.fineAmount = fineAmount;
    }
}
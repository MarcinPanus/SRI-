package edu.pja.sri.lab07.server.handlers;

import edu.pja.sri.lab07.Book;
import edu.pja.sri.lab07.BookNotAvailable;
import edu.pja.sri.lab07.LibraryService;
import edu.pja.sri.lab07.LoanItem;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

public class LibraryServiceHandler implements LibraryService.Iface {
    private List<LoanItem> loans;
    private BookManagerHandler bookManager;

    public LibraryServiceHandler(BookManagerHandler bookManager) {
        loans = new ArrayList<>();
        this.bookManager = bookManager;
    }

    @Override
    public void loanBook(LoanItem item) throws BookNotAvailable, TException {
        if (bookManager.checkStock(item.bookId)) {
            for (Book book : bookManager.getAllBooks()) {
                if (book.id == item.bookId) {
                    if(book.inStock > 0) {
                        loans.add(item);
                        book.inStock--;
                    }
                        return;
                    } else {
                        throw new BookNotAvailable("Requested quantity is not available.");
                    }
                }
        } else {
            throw new BookNotAvailable("Book with ID: " + item.bookId + " is not available.");
        }
    }

    @Override
    public void returnBook(LoanItem item) throws TException {
        loans.removeIf(loan -> loan.bookId == item.bookId && loan.readerId == item.readerId);
    }

    @Override
    public void placeOrder(int bookId) throws TException {
        for (Book book : bookManager.getAllBooks()) {
            if (book.id == bookId) {
                book.inStock++;
                return;
            }
        }
        throw new TException("Book with ID: " + bookId + " not found.");
    }
}

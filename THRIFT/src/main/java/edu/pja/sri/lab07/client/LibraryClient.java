package edu.pja.sri.lab07.client;

import edu.pja.sri.lab07.Book;
import edu.pja.sri.lab07.BookManager;
import edu.pja.sri.lab07.LibraryService;
import edu.pja.sri.lab07.LoanItem;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

import java.util.List;

public class LibraryClient {
    public static void perform(BookManager.Client bookManagerClient, LibraryService.Client libraryServiceClient) throws TException {
        List<Book> allBooks = bookManagerClient.getAllBooks();
        System.out.println("All books in library:");
        for (Book book : allBooks) {
            System.out.println("ID: " + book.id + ", Title: " + book.title + ", Author: " + book.author + ", Year: " + book.publicationYear + ", In stock: " + book.inStock);
        }
        System.out.println();

        Book loanedBook = allBooks.get(0);
        LoanItem loanItem = new LoanItem(loanedBook.id, 1);
        libraryServiceClient.loanBook(loanItem);
        System.out.println("Borrowed book - " + loanedBook.title + ". Current number of copies:  " + bookManagerClient.getAllBooks().get(0).inStock);

        libraryServiceClient.returnBook(loanItem);
        libraryServiceClient.placeOrder(allBooks.get(0).id);
        System.out.println("Returned book - " + loanedBook.title + ". Current number of copies:  " + bookManagerClient.getAllBooks().get(0).inStock);

        System.out.println();
        Book newBook = new Book(5, "New Book", "New Author", 2023, 3);
        bookManagerClient.addBook(newBook);
        System.out.println("Added a new book: " + newBook);
        System.out.println("All books after adding a new book: " + bookManagerClient.getAllBooks());

        System.out.println();
        bookManagerClient.removeBook(newBook.id);
        System.out.println("Removed book with ID: " + newBook.id);
        System.out.println("All books after removing a book: " + bookManagerClient.getAllBooks());
    }

    public static void main(String [] args) {
        try {
            TTransport transport = new TSocket("localhost", 9090);
            TProtocol protocol = new TBinaryProtocol(transport);
            BookManager.Client bookManagerClient = new BookManager.Client(protocol);

            TTransport transport2 = new TSocket("localhost", 9091);
            TProtocol protocol2 = new TBinaryProtocol(transport2);
            LibraryService.Client libraryServiceClient = new LibraryService.Client(protocol2);

            transport.open();
            transport2.open();

            perform(bookManagerClient, libraryServiceClient);

            transport.close();
            transport2.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }
}



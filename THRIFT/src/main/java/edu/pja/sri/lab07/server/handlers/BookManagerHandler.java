package edu.pja.sri.lab07.server.handlers;

import edu.pja.sri.lab07.Book;
import edu.pja.sri.lab07.BookManager;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;

public class BookManagerHandler implements BookManager.Iface {
    private List<Book> books;

    public BookManagerHandler() {
        books = new ArrayList<>();

        books.add(new Book(1, "1984", "George Orwell", 1949, 10));
        books.add(new Book(2, "Dune", "Frank Herbert", 1965, 5));
        books.add(new Book(3, "Moby Dick", "Herman Melville", 1851, 2));
    }

    @Override
    public List<Book> getAllBooks() throws TException {
        return books;
    }

    public void addBook(Book book) throws TException {
        books.add(book);
    }

    public void removeBook(int bookId) throws TException {
        books.removeIf(book -> book.id == bookId);
    }

    public boolean checkStock(int bookId) throws TException {
        for (Book book : books) {
            if (book.id == bookId && book.inStock > 0) {
                return true;
            }
        }
        return false;
    }
}

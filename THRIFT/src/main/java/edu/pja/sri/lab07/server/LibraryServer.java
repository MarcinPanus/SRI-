package edu.pja.sri.lab07.server;

import edu.pja.sri.lab07.BookManager;
import edu.pja.sri.lab07.LibraryService;
import edu.pja.sri.lab07.server.handlers.BookManagerHandler;
import edu.pja.sri.lab07.server.handlers.LibraryServiceHandler;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class LibraryServer {
    public static void startBookManagerServer(BookManager.Processor<BookManagerHandler> processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the BookManager server on port 9090...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startLibraryServiceServer(LibraryService.Processor<LibraryServiceHandler> processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9091);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the LibraryService server on port 9091...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BookManagerHandler bookManager = new BookManagerHandler();
        LibraryServiceHandler libraryService = new LibraryServiceHandler(bookManager);

        Thread bookManagerThread = new Thread(() -> startBookManagerServer(new BookManager.Processor(bookManager)));
        Thread libraryServiceThread = new Thread(() -> startLibraryServiceServer(new LibraryService.Processor(libraryService)));

        bookManagerThread.start();
        libraryServiceThread.start();
    }
}



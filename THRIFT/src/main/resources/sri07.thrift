namespace java edu.pja.sri.lab07

struct Book {
    1: required i32 id;
    2: required string title;
    3: required string author;
    4: required i32 publicationYear;
    5: required i32 inStock;
}

struct LoanItem {
    1: required i32 bookId;
    2: required i32 readerId;
}

exception BookNotAvailable {
    1: string message
}

service BookManager {
    list<Book> getAllBooks()
    void addBook(1: Book book)
    void removeBook(1: i32 bookId)
}

service LibraryService {
    void loanBook(1: LoanItem item) throws (1:BookNotAvailable err)
    void returnBook(1: LoanItem item)
    void placeOrder(1: i32 bookId)
}



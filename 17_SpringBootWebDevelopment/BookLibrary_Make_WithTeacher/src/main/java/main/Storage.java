package main;

import main.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {

    private static int currentId = 1;
    private static HashMap<Integer, Book> books = new HashMap<Integer, Book>();

    public static List<Book> getAllBooks() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.addAll(books.values());
        return bookList;
    }

    public static int addBook(Book book) {
        int id = currentId++;
        book.setId(id);
        books.put(id, book);
        return id;
    }

    public static Book getBook(int bookId) {
        if (books.containsKey(bookId)) {
            return books.get(bookId);
        }
        return null;
    }
}

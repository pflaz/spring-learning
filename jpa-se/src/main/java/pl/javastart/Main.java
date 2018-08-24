package pl.javastart;

import pl.javastart.dao.BookDao;
import pl.javastart.dao.BookDaoImpl;
import pl.javastart.model.Book;


public class Main {
    public static void main(String[] args) {
        Book book = new Book("12345", "title", "author");

        BookDao bookDao = new BookDaoImpl();
        bookDao.save(book);

        System.out.println("Book saved");

        Book book1 = bookDao.get(1L);
        System.out.println(book1);
        bookDao.cleanUp();
    }
}

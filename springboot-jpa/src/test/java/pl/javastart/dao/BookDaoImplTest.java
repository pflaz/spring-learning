package pl.javastart.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.javastart.model.Book;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BookDaoImplTest {

    @Autowired
    BookDao dao;

    @Test
    public void save() {
        // Given
        Book book = new Book("123123", "tit", "auth");

        // When
        dao.save(book);
        long bookId = book.getId();

        // Then
        try {
            Assert.assertNotEquals(0, bookId);
        } finally {
            dao.remove(bookId);
        }
    }

    @Test
    public void get() {
        // Given
        Book book = new Book("123124", "tit", "auth");
        dao.save(book);
        long insertedId = book.getId();

        // When
        Book retrievedBook = dao.get(insertedId);
        // Then
        try {
            Assert.assertEquals(book, retrievedBook);
        } finally {
            dao.remove(insertedId);
        }
    }

    @Test
    public void update() {
        // Given
        Book book = new Book("123125", "tit", "auth");
        dao.save(book);
        long insertedId = book.getId();
        Book bookChanged = new Book("4321", "title changed", "author changed");
        bookChanged.setId(insertedId);
        // When
        dao.update(bookChanged);
        // Then
        Book retrievedBook = dao.get(insertedId);
        try {
            Assert.assertEquals(bookChanged, retrievedBook);
        } finally {
            dao.remove(insertedId);
        }
    }

    @Test
    public void remove() {
        // Given
        Book book = new Book("123126", "tit", "auth");
        dao.save(book);
        long insertedId = book.getId();
        // When
        dao.remove(insertedId);
        Book retrievedBook = dao.get(insertedId);
        // Then
        Assert.assertNull(retrievedBook);
    }
}
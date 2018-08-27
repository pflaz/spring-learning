package pl.javastart.dao;

import pl.javastart.model.Book;

public interface BookDao {
    void save(Book book);
    Book get(Long id);
    void update(Book book);
    void remove(Long bookId);
}

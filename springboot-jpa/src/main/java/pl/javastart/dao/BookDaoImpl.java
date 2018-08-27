package pl.javastart.dao;

import org.springframework.stereotype.Repository;
import pl.javastart.model.Book;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public BookDaoImpl() {
    }

    @Override
    @Transactional
    public void save(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book get(Long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }

    @Override
    @Transactional
    public void update(Book book) {
        Book find = entityManager.find(Book.class, book.getId());
        if (find != null) {
            find.setTitle(book.getTitle());
            find.setAuthor(book.getAuthor());
            find.setIsbn(book.getIsbn());
        }

    }

    @Override
    @Transactional
    public void remove(Long bookId) {
        Book find = entityManager.find(Book.class, bookId);
            entityManager.remove(find);
    }
}

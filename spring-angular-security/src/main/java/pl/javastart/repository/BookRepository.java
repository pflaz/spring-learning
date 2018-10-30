package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

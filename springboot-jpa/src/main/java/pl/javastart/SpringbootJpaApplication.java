package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.dao.BookDao;
import pl.javastart.model.Book;

@SpringBootApplication
public class SpringbootJpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootJpaApplication.class, args);
        BookDao dao = ctx.getBean(BookDao.class);
        Book book = new Book("123", "Spring boot title", null);
        dao.save(book);
        Book book1 = dao.get(1L);
        System.out.println(book1);
    }
}

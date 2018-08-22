package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.javastart.model.Book;
import pl.javastart.service.BookRepository;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringAopApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringAopApplication.class);

        BookRepository repo = ctx.getBean(BookRepository.class);
        repo.add(new Book("1234567890123", "First title", "First author"));
        repo.add(new Book("1234567890124", "Second title", "Second author"));
        repo.add(new Book("1234567890125", "Third title", "Third author"));
//        repo.add(null);
        Book book = repo.get("1234567890123");
        System.out.println(book);
        ctx.close();

    }
}

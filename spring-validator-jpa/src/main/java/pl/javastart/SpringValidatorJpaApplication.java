package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.orm.jpa.JpaSystemException;
import pl.javastart.model.Person;
import pl.javastart.repository.PersonRepository;
import pl.javastart.service.PersonService;

import javax.validation.ConstraintViolationException;

@SpringBootApplication
public class SpringValidatorJpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringValidatorJpaApplication.class, args);
        Person person = new Person("Jan", null, "zlymail", 0);
        PersonService personService = ctx.getBean(PersonService.class);
        personService.add(person);

        ctx.close();
    }
}

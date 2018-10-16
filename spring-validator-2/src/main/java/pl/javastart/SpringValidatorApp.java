package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.javastart.model.Person;
import pl.javastart.service.PersonService;

@Configuration
@ComponentScan
public class SpringValidatorApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringValidatorApp.class);

        PersonService personService = ctx.getBean(PersonService.class);
        Person person1 = new Person("Jan", "Kowalski", "jan@kowalski.org", 35);
        personService.addPerson(person1);

        Person person2 = new Person("Anna", null, "zlymail", 0);
        personService.addPerson(person2);

        System.out.println("People: " + personService.getPeople().size());
        for (Person person: personService.getPeople()) {
            System.out.println(person);
        }

        ctx.close();
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}

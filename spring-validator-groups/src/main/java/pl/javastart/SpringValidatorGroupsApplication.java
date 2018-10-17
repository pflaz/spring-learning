package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.javastart.model.Project;
import pl.javastart.service.ProjectService;

import javax.validation.Validator;
import java.sql.Date;
import java.time.Instant;

@SpringBootApplication
public class SpringValidatorGroupsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringValidatorGroupsApplication.class, args);
        ProjectService service = ctx.getBean(ProjectService.class);

        Project project = new Project();
        project.setTitle("Prototyp samochodu");
        project.setDate(Date.from(Instant.now()));

        boolean validateDraft = service.validateDraft(project);
        System.out.println("Draft project valid? " + validateDraft);

        project.setOwner("John Doe");
        project.setDescription("opis");

        boolean validateFull = service.validateFull(project);
        System.out.println("Full project valid? " + validateFull);
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}

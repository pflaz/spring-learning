package pl.javastart.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Random;

@Configuration
public class AppConfig {

    @Bean
    @Qualifier("randomNumber")
    public int getRandomNumber() {
        return new Random().nextInt();
    }

}

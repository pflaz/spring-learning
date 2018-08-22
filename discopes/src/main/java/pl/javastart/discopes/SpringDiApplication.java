package pl.javastart.discopes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.javastart.discopes.beans.MessagePrinter;
import pl.javastart.discopes.beans.MessageProducer;
import pl.javastart.discopes.beans.MessageProducerPrototype;

@Configuration
@ComponentScan
public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDiApplication.class);

        MessageProducer bean1 = ctx.getBean(MessageProducer.class);
        System.out.println("Bean1 (singleton): " + bean1.getNumber());

        MessageProducer bean2 = ctx.getBean(MessageProducer.class);
        System.out.println("Bean2 (singleton): " + bean2.getNumber());

        MessageProducerPrototype bean3 = ctx.getBean(MessageProducerPrototype.class);
        System.out.println("Bean3 (prototype): " + bean3.getNumber());

        MessageProducerPrototype bean4 = ctx.getBean(MessageProducerPrototype.class);
        System.out.println("Bean4 (prototype): " + bean4.getNumber());

        MessagePrinter bean5 = ctx.getBean(MessagePrinter.class);
        bean5.printMessage();

        MessagePrinter bean6 = ctx.getBean(MessagePrinter.class);
        bean6.printMessage();

        ctx.close();
    }
}

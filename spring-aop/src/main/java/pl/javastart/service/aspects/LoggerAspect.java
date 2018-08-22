package pl.javastart.service.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import pl.javastart.model.Book;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    private static int count = 0;

    @Before("pl.javastart.service.aspects.AspectUtil.allBookRepositoryMethods()")
    public void logInfoBefore(JoinPoint joinPoint) {
        count++;
        Object[] args = joinPoint.getArgs();
        System.out.printf("%d Log before %s with args: %s\n",
                count,
                joinPoint.getSignature(),
                Arrays.toString(args));
    }

    @After("pl.javastart.service.aspects.AspectUtil.allBookRepositoryMethods()")
    public void logInfoAfter() {
        System.out.println("Method executed");
    }

    @AfterThrowing(
            pointcut = "pl.javastart.service.aspects.AspectUtil.allBookRepositoryMethods()",
            throwing = "error")
    public void logError(JoinPoint joinPoint, Throwable error) {
        System.out.printf("Method %s finished with error %s", joinPoint.getSignature(), error.getMessage());
    }

    @AfterReturning(
            pointcut = "execution(* pl.javastart.service.BookRepository.get(..)) && args(isbn)",
            returning = "result")
    public void logSuccess(JoinPoint joinPoint, String isbn, Book result) {
        if (result != null)
            System.out.printf("Method get() succesfully returned value %s for isbn %s\n", result, isbn);
    }
}

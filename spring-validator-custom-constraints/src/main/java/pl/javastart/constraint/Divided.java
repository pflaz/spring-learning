package pl.javastart.constraint;

import pl.javastart.validator.NumberDivideValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NumberDivideValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Divided {
    String message() default "Number has to be divided by {by}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int by() default 1;
}

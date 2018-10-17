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
    String message() default "{pl.javastart.constraint.Divided.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int by() default 1;

}

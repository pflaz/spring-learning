package pl.javastart.validator;

import pl.javastart.constraint.Divided;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberDivideValidator implements ConstraintValidator<Divided, Integer> {

    private int divider;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value % divider == 0;
    }

    @Override
    public void initialize(Divided annotation) {
        divider = annotation.by();

    }
}

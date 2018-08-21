package pl.javastart.beans.decorators;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Decorator(type = Decorator.DecoratorType.LOWER_CASE)
public class LowerCaseMessageDecorator implements MessageDecorator{
    @Override
    public String decorate(String msg) {
        return msg.toLowerCase();
    }
}

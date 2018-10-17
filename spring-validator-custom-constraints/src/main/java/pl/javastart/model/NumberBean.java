package pl.javastart.model;

import pl.javastart.constraint.Divided;

public class NumberBean {

    @Divided(by = 3, message = "Liczba ${validatedValue} nie jest podzielna przez {by}")
    private Integer number;

    public NumberBean(Integer number) {
        this.number = number;
    }

    NumberBean() {}

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

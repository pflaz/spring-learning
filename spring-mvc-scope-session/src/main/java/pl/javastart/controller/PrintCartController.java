package pl.javastart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.component.ShoppingCart;

@Controller
public class PrintCartController {

    private ShoppingCart shoppingCart;

    @Autowired
    public PrintCartController(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @GetMapping("/print")
    public String printCart() {
        shoppingCart.getProducts().forEach(System.out::println);
        return "index.jsp";
    }
}

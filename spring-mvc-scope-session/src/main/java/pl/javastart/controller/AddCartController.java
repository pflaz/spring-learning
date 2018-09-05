package pl.javastart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.component.ShoppingCart;

@Controller
public class AddCartController {
    private ShoppingCart shoppingCart;

    @Autowired
    public AddCartController(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String product) {
        shoppingCart.addProduct(product);
        return "index.jsp";
    }
}

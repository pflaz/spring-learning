package pl.javastart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(Model model) {
        System.out.println("test");
        model.addAttribute("helloMessage", "Welcome to Srping security");
        return "home";
    }
}

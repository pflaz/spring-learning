package pl.javastart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.javastart.model.Book;

import java.util.Arrays;

@Controller
public class AppController {

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("book", new Book());
        return "home";
    }

    @GetMapping("/if")
    public String ifExample(Model model) {
        model.addAttribute("text", "Sample text");
        model.addAttribute("a", 123);
        model.addAttribute("b", 456);
        return "if";
    }

    @GetMapping("/loop")
    public String loopExample(Model model) {
        model.addAttribute("books", Arrays.asList(
                new Book("Book1", "Author1", 59.99),
                new Book("Book2", "Author2", 69.99),
                new Book("Book3", "Author3", 79.99),
                new Book("Book4", "Author4", 89.99),
                new Book("Book5", "Author5", 99.99),
                new Book("Book6", "Author6", 19.99)
        ));
        return "loop";
    }

    @PostMapping("/bookadd")
    public String bookAdd(@ModelAttribute Book book, Model model) {
        model.addAttribute("message", "Book" + book + " added");
        return "home";
    }
}


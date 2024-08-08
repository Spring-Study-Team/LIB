package hanghae.study.frameworkstudybeforecourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model) {
        List<String> items = Arrays.asList("item1", "item2", "item3");

        model.addAttribute("name", "Lee");
        model.addAttribute("items", items);
        model.addAttribute("condition", true);

        return "main";
    }
}

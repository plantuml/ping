package io.plantuml.ping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        final WelcomeData data = new WelcomeData("dynamic title", "This is the Dynamic Welcome template");
        model.addAttribute("data", data);
        return "welcome";
    }
}

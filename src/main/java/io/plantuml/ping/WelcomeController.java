package io.plantuml.ping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping(path = "/welcome")
    public String welcome() {
        return "welcome";
    }

}
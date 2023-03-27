package io.plantuml.ping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "<html><h1>hello in HTML<h2></html>";
    }
}

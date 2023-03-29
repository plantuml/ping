package io.plantuml.ping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/home")
    public String hello() {
        final StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<ul>");

        sb.append("<li>");
        sb.append("<a href=hello>hello: simple HTML rest</a>");
        sb.append("</li>");

        sb.append("<li>");
        sb.append("<a href=ping>ping: simple JSON rest</a>");
        sb.append("</li>");

        sb.append("<li>");
        sb.append("<a href=static/static.html>static HTML file</a>");
        sb.append("</li>");

        sb.append("<li>");
        sb.append("<a href=welcome>Welcome JSP</a>");
        sb.append("</li>");

        sb.append("</ul>");
        sb.append("</html>");
        return sb.toString();
    }
}
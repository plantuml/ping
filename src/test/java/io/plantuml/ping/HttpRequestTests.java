package io.plantuml.ping;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTests {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void helloControllerShoudReturnHelloPage() throws Exception {
        assertThat(httpGetString("/hello")).contains("hello in HTML");
    }

    @Test
    public void pingServiceShouldRespondPong() throws Exception {
        String resp = httpGetString("/ping");
        assertThat(resp).contains("pong");
        String pong = JsonPath.parse(resp).read("$.pong");
        assertThat(pong).isNotBlank();
    }

    @Test
    public void staticHtmlPageShouldBeVisisble() throws Exception {
        assertThat(httpGetString("/static.html")).contains("static HTML file");
    }

    @Test
    public void welcomeControllerShouldReturnWellcomeTemplate() throws Exception {
        assertThat(httpGetString("/welcome")).contains("This is the Dynamic Welcome template");
    }

    private String httpGetString(String url) {
        return this.restTemplate.getForObject(absoluteUrl(url), String.class);
    }

    private String absoluteUrl(String url) {
        StringBuilder absoluteUrl = new StringBuilder();
        if (url.startsWith("http")) {
            //absolute url
            absoluteUrl.append(url);
        } else {
            //relative url
            absoluteUrl.append("http://localhost:").append(port).append("/ping");
            if (url.startsWith("/")) {
                absoluteUrl.append(url);
            } else {
                absoluteUrl.append('/').append(url);
            }
        }
        return absoluteUrl.toString();
    }

}

package io.plantuml.ping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SmokeTests {

    @Autowired
    private PingController pingController;

    @Autowired
    private HelloController helloController;

    @Autowired
    private WelcomeController welcomeController;


    @Test
    void pingControllerShouldRespondPong() {
        assertThat(pingController).isNotNull();
        assertThat(pingController.ping()).contains("pong");
    }

    @Test
    void helloControllerShouldRespondHello() {
        assertThat(helloController).isNotNull();
        assertThat(helloController.hello()).contains("hello in HTML");
    }

    @Test
    void welcomeControllerControlerShouldReturnModel() {
        //given
        WelcomeData expected = new WelcomeData("dynamic title", "This is the Dynamic Welcome template");
        Model model = mock(Model.class);
        //when
        String resp = welcomeController.welcome(model);
        //then
        assertThat(resp).isEqualTo("welcome");
        verify(model).addAttribute(eq("data"), eq(expected));
    }
}

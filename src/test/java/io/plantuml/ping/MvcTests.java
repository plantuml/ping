package io.plantuml.ping;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class MvcTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WelcomeController welcomeController;

    @Mock
    private Model model;

    @Test
    void welcomeControllerShouldRespondWelcome() throws Exception {
        assertThat(welcomeController).isNotNull();
        WelcomeData expectedData = new WelcomeData("dynamic title", "This is the Dynamic Welcome template");
        mockMvc.perform(get("/welcome"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("data", expectedData));
        assertThat(welcomeController.welcome(model)).isEqualTo("welcome");
    }

}

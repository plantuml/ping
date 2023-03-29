package io.plantuml.ping;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class WelcomeData {
    private final String title;
    private final String welcomeMessage;
}

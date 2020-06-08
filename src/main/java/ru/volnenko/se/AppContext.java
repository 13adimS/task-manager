package ru.volnenko.se;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.volnenko.se.controller.Bootstrap;

@Configuration
@ComponentScan
public class AppContext {

    @Bean
    public Bootstrap bootstrap() {
        return new Bootstrap();
    }
}

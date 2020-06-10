package ru.volnenko.se;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@ComponentScan
public class AppContext {

    @Bean(name = "CustomAsyncExecutor")
    public Executor getAsyncExecutor() {
        return new SimpleAsyncTaskExecutor("Custom");
    }
}


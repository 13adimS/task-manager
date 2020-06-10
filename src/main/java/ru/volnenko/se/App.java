package ru.volnenko.se;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.controller.Bootstrap;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        Bootstrap bootstrap = context.getBean(Bootstrap.class);
        List<Command> commands = new ArrayList<>(context.getBeansOfType(Command.class).values());
        bootstrap.init(commands);
    }

}

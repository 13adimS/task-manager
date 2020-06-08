package ru.volnenko.se;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.controller.Bootstrap;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        Bootstrap bootstrap = context.getBean(Bootstrap.class);
        List<AbstractCommand> commands = new ArrayList<>(context.getBeansOfType(AbstractCommand.class).values());
        bootstrap.init(commands);
    }

}

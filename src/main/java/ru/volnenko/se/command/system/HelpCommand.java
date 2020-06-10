package ru.volnenko.se.command.system;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.command.CommandEvent;

/**
 * @author Denis Volnenko
 */
@Component
public class HelpCommand extends Command {

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String description() {
        return "Show all commands.";
    }

    @Override
    @Async("CustomAsyncExecutor")
    @EventListener(condition = "#event.command == 'help'")
    public void execute(CommandEvent event) {
        event.getSource();
        for (Command command: bootstrap.getListCommand()) {
            System.out.println(command.command()+ ": " + command.description());
        }
    }
}

package ru.volnenko.se.command.project;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.command.CommandEvent;

/**
 * @author Denis Volnenko
 */
@Component
public class ProjectRemoveCommand extends Command {

    @Override
    public String command() {
        return "project-remove";
    }

    @Override
    public String description() {
        return "Remove selected project.";
    }

    @Override
    @Async("CustomAsyncExecutor")
    @EventListener(condition = "#event.command == 'project-remove'")
    public void execute(CommandEvent event) {

    }

}

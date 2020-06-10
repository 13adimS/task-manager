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
public class ProjectClearCommand extends Command {

    @Override
    public String command() {
        return "project-clear";
    }

    @Override
    public String description() {
        return "Remove all projects.";
    }

    @Override
    @Async("CustomAsyncExecutor")
    @EventListener(condition = "#event.command == 'project-clear'")
    public void execute(CommandEvent event) {
        bootstrap.getProjectRepository().clear();
        System.out.println("[ALL PROJECTS REMOVED]");
    }

}

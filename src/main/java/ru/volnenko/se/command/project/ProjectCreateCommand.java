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
public class ProjectCreateCommand extends Command {

    @Override
    public String description() {
        return "Create new project.";
    }

    @Override
    public String command() {
        return "project-create";
    }

    @Override
    @Async("CustomAsyncExecutor")
    @EventListener(condition = "#event.command == 'project-create'")
    public void execute(CommandEvent event) {
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        final String name = bootstrap.nextLine();
        bootstrap.getProjectRepository().createProject(name);
        System.out.println("[OK]");
        System.out.println();
    }

}

package ru.volnenko.se.command.project;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.command.CommandEvent;
import ru.volnenko.se.entity.Project;

/**
 * @author Denis Volnenko
 */
@Component
public class ProjectListCommand extends Command {

    @Override
    public String command() {
        return "project-list";
    }

    @Override
    public String description() {
        return "Show all projects.";
    }

    @Override
    @Async("CustomAsyncExecutor")
    @EventListener(condition = "#event.command == 'project-list'")
    public void execute(CommandEvent event) {
        System.out.println("[PROJECT LIST]");
        int index = 1;
        for (Project project: bootstrap.getProjectService().getListProject()) {
            System.out.println(index++ + ". " + project.getName());
        }
        System.out.println();
    }

}

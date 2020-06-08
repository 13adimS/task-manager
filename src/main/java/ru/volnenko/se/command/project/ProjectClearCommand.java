package ru.volnenko.se.command.project;

import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
@Component
public final class ProjectClearCommand extends AbstractCommand {

    @Override
    public String command() {
        return "project-clear";
    }

    @Override
    public String description() {
        return "Remove all projects.";
    }

    @Override
    public void execute() {
        bootstrap.getProjectRepository().clear();
        System.out.println("[ALL PROJECTS REMOVED]");
    }

}

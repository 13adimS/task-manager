package ru.volnenko.se.command.task;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.command.CommandEvent;

/**
 * @author Denis Volnenko
 */
@Component
public class TaskCreateCommand extends Command {

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "Create new task.";
    }

    @Override
    @Async("CustomAsyncExecutor")
    @EventListener(condition = "#event.command == 'task-create'")
    public void execute(CommandEvent event) {
        System.out.println("[TASK CREATE]");
        System.out.println("ENTER NAME:");
        final String name = bootstrap.nextLine();
        bootstrap.getTaskRepository().createTask(name);
        System.out.println("[OK]");
        System.out.println();
    }

}

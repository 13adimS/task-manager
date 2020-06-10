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
public class TaskClearCommand extends Command {

    @Override
    public String description() {
        return "Remove all tasks.";
    }

    @Override
    public String command() {
        return "task-clear";
    }

    @Override
    @Async("CustomAsyncExecutor")
    @EventListener(condition = "#event.command == 'task-clear'")
    public void execute(CommandEvent event) {
        bootstrap.getTaskRepository().clear();
        System.out.println("[ALL TASK REMOVED]");
    }

}

package ru.volnenko.se.command.task;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.command.CommandEvent;
import ru.volnenko.se.entity.Task;

/**
 * @author Denis Volnenko
 */
@Component
public class TaskListCommand extends Command {

    @Override
    public String command() {
        return "task-list";
    }

    @Override
    public String description() {
        return "Show all tasks.";
    }

    @Override
    @Async("CustomAsyncExecutor")
    @EventListener(condition = "#event.command == 'task-list'")
    public void execute(CommandEvent event) {
        System.out.println("[TASK LIST]");
        int index = 1;
        for (Task task: bootstrap.getTaskRepository().getListTask()) {
            System.out.println(index + ". " + task.getName());
            index++;
        }
        System.out.println();
    }

}

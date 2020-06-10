package ru.volnenko.se.command.data.bin;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.command.CommandEvent;
import ru.volnenko.se.constant.DataConstant;
import ru.volnenko.se.entity.Project;
import ru.volnenko.se.entity.Task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

/**
 * @author Denis Volnenko
 */
@Component
public class DataBinarySaveCommand extends Command {

    @Override
    public String command() {
        return "data-bin-save";
    }

    @Override
    public String description() {
        return "Load data from binary file.";
    }

    @Override
    @Async("CustomAsyncExecutor")
    @EventListener(condition = "#event.command == 'data-bin-save'")
    public void execute(CommandEvent event) throws Exception {
        System.out.println("[DATA BINARY SAVE]");
        final Project[] projects = bootstrap.getProjectService().getListProject().toArray(new Project[] {});
        final Task[] tasks = bootstrap.getTaskService().getListTask().toArray(new Task[] {});

        final File file = new File(DataConstant.FILE_BINARY);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());

        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(projects);
        objectOutputStream.writeObject(tasks);
        objectOutputStream.close();
        fileOutputStream.close();

        System.out.println("[OK]");
        System.out.println();
    }

}

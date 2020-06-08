package ru.volnenko.se.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.volnenko.se.api.repository.IProjectRepository;
import ru.volnenko.se.api.repository.ITaskRepository;
import ru.volnenko.se.api.service.ITaskService;
import ru.volnenko.se.entity.Project;
import ru.volnenko.se.entity.Task;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author Denis Volnenko
 */
@Service
public final class TaskService implements ITaskService {

    @Resource
    private ITaskRepository taskRepository;

    @Resource
    private IProjectRepository projectRepository;

    @Override
    public Task createTask(final String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.createTask(name);
    }

    @Override
    public Task getTaskById(final String id) {
        return taskRepository.getTaskById(id);
    }

    @Override
    public Task merge(final Task task) {
        return taskRepository.merge(task);
    }

    @Override
    public void removeTaskById(final String id) {
        taskRepository.removeTaskById(id);
    }

    @Override
    public List<Task> getListTask() {
        return taskRepository.getListTask();
    }

    @Override
    public void clear() {
        taskRepository.clear();
    }

    @Override
    public Task createTaskByProject(final String projectId, final String taskName) {
        final Project project = projectRepository.getProjectById(projectId);
        if (project == null) return null;
        final Task task = taskRepository.createTask(taskName);
        task.setProjectId(project.getId());
        return task;
    }

    @Override
    public Task getByOrderIndex(Integer orderIndex) {
        return taskRepository.getByOrderIndex(orderIndex);
    }

    @Override
    public void merge(Task... tasks) {
        taskRepository.merge(tasks);
    }

    @Override
    public void load(Task... tasks) {
        taskRepository.load(tasks);
    }

    @Override
    public void load(Collection<Task> tasks) {
        taskRepository.load(tasks);
    }

    @Override
    public void removeTaskByOrderIndex(Integer orderIndex) {
        taskRepository.removeTaskByOrderIndex(orderIndex);
    }

}

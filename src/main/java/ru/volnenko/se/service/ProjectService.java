package ru.volnenko.se.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.volnenko.se.api.repository.IProjectRepository;
import ru.volnenko.se.entity.Project;
import ru.volnenko.se.repository.ProjectRepository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author Denis Volnenko
 */
@Service
public final class ProjectService implements ru.volnenko.se.api.service.IProjectService {

    @Resource
    private IProjectRepository projectRepository;

    @Override
    public Project createProject(final String name) {
        if (name == null || name.isEmpty()) return null;
        return projectRepository.createProject(name);
    }

    @Override
    public Project merge(final Project project) {
        return projectRepository.merge(project);
    }

    @Override
    public Project getProjectById(final String id) {
        return projectRepository.getProjectById(id);
    }

    @Override
    public void removeProjectById(final String id) {
        projectRepository.removeProjectById(id);
    }

    @Override
    public List<Project> getListProject() {
        return projectRepository.getListProject();
    }

    @Override
    public void clear() {
        projectRepository.clear();
    }

    @Override
    public void merge(Project... projects) {
        projectRepository.merge(projects);
    }

    @Override
    public void load(Collection<Project> projects) {
        projectRepository.load(projects);
    }

    @Override
    public void load(Project... projects) {
        projectRepository.load(projects);
    }

    @Override
    public Project removeByOrderIndex(Integer orderIndex) {
        if (orderIndex == null) return null;
        return projectRepository.removeByOrderIndex(orderIndex);
    }

}

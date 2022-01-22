package com.santosh.springrestfulserviceexample.service;

import com.santosh.springrestfulserviceexample.model.Project;
import com.santosh.springrestfulserviceexample.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> fetchProjectList(){
        return projectRepository.getAllProjects();
    }

    public Project getProject(int id){
        return projectRepository.findProjectById(id);
    }

    public Project addProject(String name,String description){
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);

        projectRepository.addProject(project);

        return project;
    }
}

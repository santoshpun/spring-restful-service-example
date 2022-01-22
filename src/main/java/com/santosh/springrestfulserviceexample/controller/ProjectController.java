package com.santosh.springrestfulserviceexample.controller;

import com.santosh.springrestfulserviceexample.model.Project;
import com.santosh.springrestfulserviceexample.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.fetchProjectList();
        return new ResponseEntity<List<Project>>(projects, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") int id) {
        Project project = projectService.getProject(id);
        return new ResponseEntity<Project>(project, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        Project created = projectService.addProject(project.getName(), project.getDescription());
        return new ResponseEntity<Project>(created, new HttpHeaders(), HttpStatus.CREATED);
    }
}

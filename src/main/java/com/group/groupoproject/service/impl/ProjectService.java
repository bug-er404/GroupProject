package com.group.groupoproject.service.impl;

import com.group.groupoproject.models.Project;
import com.group.groupoproject.DAO.ProjectRepository;


import com.group.groupoproject.service.ProjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements ProjectServiceInterface {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project findByProjectName(String projectName){
        return projectRepository.findByProjectName(projectName);
    }

    @Override
    public Project findByProjectCode(int projectCode){
        return projectRepository.findByProjectCode(projectCode);
    }

    @Override
    public void deleteByProjectCode(int projectCode){
        projectRepository.deleteByProjectCode(projectCode);
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);

    }

    @Override
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }
}

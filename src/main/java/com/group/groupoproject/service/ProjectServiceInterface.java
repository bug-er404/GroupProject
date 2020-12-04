package com.group.groupoproject.service;

import com.group.groupoproject.models.Project;

import java.util.List;

public interface ProjectServiceInterface {
    Project findByProjectName(String ProjectNam);
    Project findByProjectCode(int ProjectCode);
    Project saveProject(Project project);
    Project updateProject(Project project);
    List<Project> findAll();
    void deleteByProjectCode(int projectCode);
}

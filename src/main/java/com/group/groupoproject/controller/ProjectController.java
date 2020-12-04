package com.group.groupoproject.controller;
import com.group.groupoproject.models.Project;
import com.group.groupoproject.models.Resource;
import com.group.groupoproject.models.ResourceDetail;
import com.group.groupoproject.models.User;
import com.group.groupoproject.service.impl.ProjectService;
import com.group.groupoproject.service.impl.ResourceService;
import com.group.groupoproject.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectServiceObj;

    @Autowired
    private UserService userServiceObj;

    @Autowired
    private ResourceService resourceServiceObj;

    @GetMapping("/all")
    public List<Project> getAllProjects() {
        return projectServiceObj.findAll();
    }

    @GetMapping("/getProjectCode")
    public Project getProjectByCode(int projectCode) {
        return projectServiceObj.findByProjectCode(projectCode);
        //.orElseThrow(() -> new ResourceNotFoundException("resource", "id", code));
    }

    @GetMapping(value = "/getProjectName")
    public Project getProjectByName(String projectName) {
        return projectServiceObj.findByProjectName(projectName);
    }


    @PostMapping("/addProject")
    public Project addProject(@RequestParam("projectCode") int projectCode
            , @RequestParam("projectName") String projectName, @RequestParam("userId") int userId) {

        Project tempProject = new Project();
        tempProject.setId(projectCode);
//        tempProject.setName(projectName);
        User user = userServiceObj.findById(userId);
        tempProject.setOwner(user);
        return projectServiceObj.saveProject(tempProject);
    }

    @PutMapping("/updateProject")
    public Project updateProjectWithCode(int projectCode, String projectName, int userId) {
        Project tempProject = projectServiceObj.findByProjectCode(projectCode);
//        tempProject.setName(projectName);
        User user = userServiceObj.findById(userId);
        tempProject.setOwner(user);
        return projectServiceObj.updateProject(tempProject);
    }

    @PutMapping("/addResource")
    public Project addResource(@RequestParam("projectCode") int projectCode,
                               @RequestParam("resourceCode") int resourceCode) {

        Project project = projectServiceObj.findByProjectCode(projectCode);
        Resource resource = resourceServiceObj.findByResourceCode(resourceCode);
        if (resource != null && project != null){
            List list = project.getProjectResource();
            // Adding resource need to figure out the constructor properly:
//            ResourceDetail newProjRes = new ResourceDetail(resource,project,"default");
//            list.add(newProjRes);
        }
        return projectServiceObj.updateProject(project);
    }

    @Transactional
    @DeleteMapping("/deleteProjectByCode")
    public ResponseEntity<?> deleteProjectByCode(int projectCode) {

        projectServiceObj.deleteByProjectCode(projectCode);

        return ResponseEntity.ok().build();
    }
}

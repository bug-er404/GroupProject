package com.group.groupoproject.controller;

import com.group.groupoproject.models.Project;
import com.group.groupoproject.models.Property;
import com.group.groupoproject.service.ProjectServiceInterface;
import com.group.groupoproject.service.PropertyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    private PropertyServiceInterface propertyServiceObj;

    @Autowired
    private ProjectServiceInterface projectServiceInterfaceObj;

    @GetMapping("/all")
    public List<Property> getAllProperty() {
        return propertyServiceObj.findAll();
    }

    @GetMapping("/getById")
    public Property findByItemId(String itemId) {
        return propertyServiceObj.findByItemId(itemId);
    }



    @PostMapping("/add")
    public Property addProjectScope(@RequestParam("id") int projectId, @RequestParam("name") String name
            , @RequestParam("type") String type, @RequestParam("formulaText") String formulaText) {

        Property tempProperty = new Property(name, type, formulaText);

        // Code to set project ID
//        Project proj = projectServiceInterfaceObj.findByProjectCode(projectId);
//        tempProperty.setId(proj);
        return propertyServiceObj.saveProperty(tempProperty);
    }

    @PutMapping("/updateName")
    public Property updateName(@RequestParam("itemId") String itemId
            , @RequestParam("name") String name) {

        Property ps = propertyServiceObj.findByItemId(itemId);
//        ps.setName(name);

        return propertyServiceObj.saveProperty(ps);
    }

    /*@Transactional
    @DeleteMapping("/delete")
    public void deleteByItemId(String itemId){
        propertyServiceObj.deleteByItemId(itemId);
    }*/
}

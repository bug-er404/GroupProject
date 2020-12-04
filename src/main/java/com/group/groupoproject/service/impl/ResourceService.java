package com.group.groupoproject.service.impl;

import com.group.groupoproject.models.Resource;
import com.group.groupoproject.service.ResourceServiceInterface;
import com.group.groupoproject.DAO.ResourceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService implements ResourceServiceInterface {
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource findByResourceName(String resourceName){
        return resourceRepository.findByResourceName(resourceName);
    }

    @Override
    public Resource findByResourceCode(int resource_code) {
        return resourceRepository.findByResourceCode(resource_code);

    }

   @Override
    public void deleteByResourceCode(int resourceCode){
        resourceRepository.deleteByResourceCode(resourceCode);
    }

    @Override
    public Resource saveResource(Resource resource) {
        return resourceRepository.save(resource);

    }

    @Override
    public Resource updateResource(Resource resource) {
        return resourceRepository.save(resource);
    }
    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }
}

package com.group.groupoproject.service;

import com.group.groupoproject.models.Resource;

import java.util.List;

public interface ResourceServiceInterface {
    Resource findByResourceName(String resourceName);
    Resource findByResourceCode(int resourceCode);
    Resource saveResource(Resource resource);
    Resource updateResource(Resource resource);
    List<Resource> findAll();
    void deleteByResourceCode(int resourceCode);
}

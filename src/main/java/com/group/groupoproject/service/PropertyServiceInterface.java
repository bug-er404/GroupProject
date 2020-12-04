package com.group.groupoproject.service;

import com.group.groupoproject.models.Property;

import java.util.List;


public interface PropertyServiceInterface {

    Property findByItemId(String itemId);
    Property saveProperty(Property tempProperty);
    List<Property> findAll();
}




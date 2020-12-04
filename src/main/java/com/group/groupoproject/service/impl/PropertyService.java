package com.group.groupoproject.service.impl;

import com.group.groupoproject.DAO.PropertyRepository;
import com.group.groupoproject.models.Property;
import com.group.groupoproject.service.PropertyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService implements PropertyServiceInterface {
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Property findByItemId(String itemId) {
        return propertyRepository.findByItemId(itemId);
    }

    @Override
    public  Property saveProperty(Property tempProperty){
        return propertyRepository.save(tempProperty);

    }

    @Override
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

}

package com.rent.repository;

import com.rent.mappers.PropertyMapper;
import com.rent.domain.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PropertyRepository {

    @Autowired
    private PropertyMapper propertyMapper;

    public Property create(Property property) {
        propertyMapper.insert(property);
        return propertyMapper.uuid(property.getUuid());
    }

}

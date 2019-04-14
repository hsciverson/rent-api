package com.rent.resources;

import com.rent.domain.Property;

import java.util.ArrayList;
import java.util.List;

class ApartmentDatabase {

    private static List<Property> properties = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            Property property;
            property = new Property();
            property.setUuid(String.valueOf(i));
            property.setAddress("Nan Jing Road" + i);
            properties.add(property);
        }
    }

    static List<Property> apartments() {
        return properties;
    }
}

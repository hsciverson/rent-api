package com.rent.resources;

import java.util.ArrayList;
import java.util.List;

class ApartmentDatabase {

    private static List<Apartment> apartments = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            Apartment apartment;
            apartment = new Apartment();
            apartment.setId(String.valueOf(i));
            apartment.setAddress("Nan Jing Road" + i);
            apartments.add(apartment);
        }
    }

    static List<Apartment> apartments() {
        return apartments;
    }
}

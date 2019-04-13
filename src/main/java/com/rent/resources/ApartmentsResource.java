package com.rent.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Path("apartments")
public class ApartmentsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Apartment> allApartments() {
        List<Apartment> list = new ArrayList<>();
        list.add(getApartment());
        return list;
    }

    private Apartment getApartment() {
        Apartment apartment = new Apartment();
        apartment.setAddress("Nan Jing Road");
        return apartment;
    }
}

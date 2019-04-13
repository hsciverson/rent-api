package com.rent.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("apartments")
public class ApartmentsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Apartment> allApartments() {
        return apartments();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Apartment apartment(@PathParam("id") String id) {
        return apartments().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    private List<Apartment> apartments() {

        List<Apartment> apartments = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Apartment apartment = new Apartment();
            apartment.setId(String.valueOf(i));
            apartment.setAddress("Nan Jing Road" + i);
            apartments.add(apartment);
        }

        return apartments;
    }
}

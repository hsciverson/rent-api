package com.rent.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static com.rent.resources.ApartmentDatabase.apartments;

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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addApartment(Apartment apartment) {

        List<Apartment> apartments = apartments();
        apartments.add(apartment);
        return Response.created(URI.create("/apartments/" + apartment.getId())).entity(apartment).build();
    }

}

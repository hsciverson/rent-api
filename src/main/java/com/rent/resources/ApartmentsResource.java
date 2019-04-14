package com.rent.resources;

import com.rent.domain.Property;
import com.rent.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static com.rent.resources.ApartmentDatabase.apartments;

@Path("apartments")
public class ApartmentsResource {

    @Autowired
    PropertyRepository properties;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Property> allApartments() {
        return apartments();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Property apartment(@PathParam("id") String id) {
        return apartments().stream()
                .filter(a -> a.getUuid().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addApartment(Property property) {
        Property created = properties.create(property);
        return Response.created(URI.create("/properties/" + created.getUuid())).entity(created).build();
    }

}

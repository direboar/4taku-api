package org.acme.service;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/santa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SantaClausResource {

    @Inject
    private SantaClausService service;

    @GET
    public Response post() {
        this.service.createGift("1111");
        return Response.ok("OK").build();
    }

    @GET
    @Path("getAll")
    public List<Gift> getAll() {
        return this.service.selectGifts();
    }

}
package org.acme.rest.json;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.entity.DeckTrackerHeroNameMapping;
import org.acme.service.DeckTrackerHeroNameMappingService;

import io.quarkus.security.Authenticated;

@Authenticated
@Path("/decktrackerheromapping")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeckTrackerHeroNameMappingResource {
    @Inject
    private DeckTrackerHeroNameMappingService service;

    @GET
    public Response getAll(){
        List<DeckTrackerHeroNameMapping> mapping = this.service.getAll();
        return Response.ok(mapping).build();
    }

}

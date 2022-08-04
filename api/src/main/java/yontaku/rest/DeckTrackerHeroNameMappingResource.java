package yontaku.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.security.Authenticated;

@Authenticated
@Path("/decktrackerheromapping")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeckTrackerHeroNameMappingResource {
    // @Inject
    // private DeckTrackerHeroNameMappingService service;

    // @GET
    // public Response getAll(){
    //     List<DeckTrackerHeroNameMapping> mapping = this.service.getAll();
    //     return Response.ok(mapping).build();
    // }

}

package yontaku.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import yontaku.entity.MinderRanking;
import yontaku.service.MinderRankingRepository;

// @Authenticated
@Path("/minderranking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MinserRankingResource {
    
    @Inject
    private MinderRankingRepository repository;
    
    @GET
    public Response getAll() {
        List<MinderRanking> minderRankings = this.repository.getAll();
        return Response.ok(minderRankings).build(); 
    }

}

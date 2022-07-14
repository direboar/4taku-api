package yontaku.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import yontaku.entity.MinderRanking;
import yontaku.rest.dto.MinderRankingView;
import yontaku.rest.mapper.MinderRankingMapper;
import yontaku.service.MinderRankingRepository;

// @Authenticated
@Path("/minderranking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MinderRankingResource {
    
    @Inject
    private MinderRankingRepository repository;

    @Inject
    private MinderRankingMapper mapper;
    
    @GET
    public Response getAll() {
        List<MinderRanking> minderRankings = this.repository.getAllValid();
        List<MinderRankingView> view = minderRankings.stream().map(
            m->this.mapper.minderRankingToMinderRankingView(m, m.getHero(), m.getHero() != null ? m.getHero().getDeckTrackerHeroNameMapping() : null)
        ).collect(Collectors.toList());
        return Response.ok(view).build(); 
    }

}

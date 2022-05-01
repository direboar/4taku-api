package org.acme.rest.json;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.acme.entity.TierTable;
import org.acme.rest.json.mapper.TierTableMapper;
import org.acme.service.HeroService;
import org.acme.service.TierTableService;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/tiertables")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TierTableResource {

    private static final Logger LOG = Logger.getLogger(TierTableResource.class);

    // TierTableMapper INSTANCE = Mappers.getMapper( TierTableMapper.class );

    @Inject
    private TierTableMapper tierTableMapper;

    @Inject
    private TierTableService tierTableService;
    
    @Inject
    private HeroService heroService;

    @POST
    // public Response save(TierTable tierTable) {
    //     int id = this.tierTableService.save(tierTable);
    //     return Response.ok("{\"id\" : "+ id +"}").build();
    // }
    public Response save(TierTableUpdateRequest tierTable) {
        TierTable entity = tierTableMapper.restTierTableUpdateRequestToTierTable(tierTable);
        int id = this.tierTableService.save(entity);
        return Response.ok("{\"id\" : "+ id +"}").build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(int id) {
        this.tierTableService.delete(id);
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    public Response get(int id) {
        TierTable tierTable = this.tierTableService.get(id);

        // //IDのみ保存されているHeroオブジェクトの値を、HeroのEntityに差し替える。
        // Map<Integer,Hero> herosFromDb = this.heroService.getAll().stream().collect(Collectors.toMap(item->item.getId(), item->item));
        // tierTable.getTiers().forEach(tier->{
        //     List<Hero> heros = new ArrayList<>();
        //     tier.getTieredHero().forEach((hero->{
        //         heros.add(herosFromDb.get(hero.getId()));
        //     }));
        //     tier.setHeros(heros);
        // });

        if(tierTable == null){
            Response.status(Status.NOT_FOUND).build();
        }
        TierTableRestView view = tierTableMapper.entityHeroToTierTableRestView(tierTable);
        return Response.ok(view).build(); 
    }
    // @GET
    // @Path("{id}")
    // public Response get(int id) {
    //     TierTable tierTable = this.tierTableService.get(id);

    //     // //IDのみ保存されているHeroオブジェクトの値を、HeroのEntityに差し替える。
    //     // Map<Integer,Hero> herosFromDb = this.heroService.getAll().stream().collect(Collectors.toMap(item->item.getId(), item->item));
    //     // tierTable.getTiers().forEach(tier->{
    //     //     List<Hero> heros = new ArrayList<>();
    //     //     tier.getTieredHero().forEach((hero->{
    //     //         heros.add(herosFromDb.get(hero.getId()));
    //     //     }));
    //     //     tier.setHeros(heros);
    //     // });

    //     LOG.info(tierTable);
    //     return tierTable != null ? Response.ok(tierTable).build() : Response.status(Status.NOT_FOUND).build();
    // }

    @GET
    public Response getPage(@RestQuery int offset, @RestQuery int limit) {
        List<TierTable> tierTables = this.tierTableService.getAllByPaging(offset, limit);
        int totalCount = this.tierTableService.getTotalCount();
        return Response.ok(new PagingResponse<>(tierTables, totalCount)).build();
    }

}

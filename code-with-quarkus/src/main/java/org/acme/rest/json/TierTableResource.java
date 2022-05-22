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
import org.acme.entity.dto.TierTablePagingDto;
import org.acme.rest.json.mapper.TierTableMapper;
import org.acme.service.TierTableService;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestQuery;

import io.quarkus.security.Authenticated;

@Authenticated
@Path("/tiertables")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TierTableResource {
    private static final Logger LOG = Logger.getLogger(TierTableResource.class);

    @Inject
    private TierTableMapper tierTableMapper;

    @Inject
    private TierTableService tierTableService;

    @POST
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

        if(tierTable == null){
            Response.status(Status.NOT_FOUND).build();
        }
        TierTableRestView view = tierTableMapper.entityHeroToTierTableRestView(tierTable);
        return Response.ok(view).build(); 
    }

    // @GET
    // public Response getPage(@RestQuery int offset, @RestQuery int limit) {
    //     List<TierTable> tierTables = this.tierTableService.getAllByPaging(offset, limit);
    //     int totalCount = this.tierTableService.getTotalCount();
    //     return Response.ok(new PagingResponse<>(tierTables, totalCount)).build();
    // }
    @GET
    public Response getPage(@RestQuery int offset, @RestQuery int limit,@RestQuery boolean owner,@RestQuery int accountId) {
        List<TierTablePagingDto> tierTables = this.tierTableService.getAllByPaging(offset, limit,owner,accountId);
        int totalCount = this.tierTableService.getTotalCount(owner,accountId);
        return Response.ok(new PagingResponse<>(tierTables, totalCount)).build();
    }

}

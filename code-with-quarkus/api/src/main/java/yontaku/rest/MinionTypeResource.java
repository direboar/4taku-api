package yontaku.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import io.quarkus.security.Authenticated;
import yontaku.entity.MinionType;
import yontaku.service.MinionTypeService;

@Authenticated
@Path("/miniontypes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MinionTypeResource {

    private static final Logger LOG = Logger.getLogger(MinionTypeResource.class);

    @Inject
    private MinionTypeService minionTypeService;

    @GET
    public Response getAll() {
        List<MinionType> minionTypes = this.minionTypeService.getAll();
        return Response.ok(minionTypes).build(); 
    }

}

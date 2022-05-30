package yontaku.rest.dto;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.security.Authenticated;
import yontaku.entity.Hero;
import yontaku.service.HeroService;

@Path("/heros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Authenticated
public class HeroResource {

    @Inject
    private HeroService heroService ;

    @GET
    public Response getAll(){
        List<Hero> heros = this.heroService.getAllAlive();
        return Response.ok(heros).build();
    }

}

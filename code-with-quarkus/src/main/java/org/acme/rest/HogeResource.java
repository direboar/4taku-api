package org.acme.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.entity.Hero;
import org.acme.service.BattlenetService;

@ApplicationScoped
@Path("/hoge")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HogeResource {
    
    @Inject
    private BattlenetService battlenetService;

    @GET
    public List<Hero> test(){
        List<Hero> heros = this.battlenetService.getHeros();
        return heros;
    }
}

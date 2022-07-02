package yontaku.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.flywaydb.core.Flyway;

@ApplicationScoped
public class FlywayService {

    @Inject
    private Flyway flyway;

    public void migrate(boolean clean){
        if(clean){
            this.flyway.clean();
        }
        this.flyway.baseline();
        this.flyway.migrate();
    }

}

package yontaku.batch;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import picocli.CommandLine;
import yontaku.service.FlywayService;

@CommandLine.Command(name = "migrate-flyway", description = "migrate-flyway")
public class MigrateFlywayCommand implements Runnable {

    @CommandLine.Option(names = {"-cl", "--clean"}, description = "execute Flyway clean command.", defaultValue = "false")
    private Boolean clean;

    private static final Logger LOG = Logger.getLogger(MigrateFlywayCommand.class);

    @Inject
    private FlywayService flywayService;
 
    @Override
    public void run() {
       LOG.info("start job!");

       this.flywayService.migrate(clean);
 
       LOG.info("end job");
    }
 

}

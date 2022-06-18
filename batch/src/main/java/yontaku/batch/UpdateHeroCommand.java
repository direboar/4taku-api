package yontaku.batch;
import java.util.List;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import picocli.CommandLine;
import yontaku.entity.Hero;
import yontaku.service.HeroService;
import yontaku.utils.BattlenetService;

@CommandLine.Command(name = "update-hero", description = "update-hero")
public class UpdateHeroCommand implements Runnable {
    
    private static final Logger LOG = Logger.getLogger(UpdateHeroBatch.class);

    @Inject
    private BattlenetService battlenetService;
 
    @Inject
    private HeroService heroService;
 
    @Override
    public void run() {
       LOG.info("start job!");
 
       // 1.battlenetからヒーロー情報を取得
       List<Hero> fromBattlenet = this.battlenetService.getHeros();
       // fromBattlenet.remove(fromBattlenet.get(0));
       // 2.ヒーロー情報を洗い替える
       this.heroService.updateFromBattlenet(fromBattlenet);
 
       LOG.info("end job");
    }
 

}

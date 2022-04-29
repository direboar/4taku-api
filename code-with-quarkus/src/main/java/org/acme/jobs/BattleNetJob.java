package org.acme.jobs;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.entity.Hero;
import org.acme.service.BattlenetService;
import org.acme.service.HeroService;
import org.jboss.logging.Logger;

@ApplicationScoped 
public class BattleNetJob {
    
    private static final Logger LOG = Logger.getLogger(BattleNetJob.class);

    @Inject
    private BattlenetService battlenetService;

    @Inject
    private HeroService heroService;

    // @Scheduled(cron="0 15 10 * * ?") 
    // @Scheduled(every="1m")
    public void getHeroData(){
        LOG.info("start job!");

        //1.battlenetからヒーロー情報を取得
        List<Hero> fromBattlenet = this.battlenetService.getHeros();
        // fromBattlenet.remove(fromBattlenet.get(0));
        //2.ヒーロー情報を洗い替える
        this.heroService.updateFromBattlenet(fromBattlenet);

        LOG.info("end job");
    }

}


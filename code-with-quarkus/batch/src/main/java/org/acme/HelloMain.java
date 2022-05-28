package org.acme;

import java.util.List;

import javax.inject.Inject;

import org.acme.entity.Hero;
import org.acme.service.BattlenetService;
import org.acme.service.HeroService;
import org.jboss.logging.Logger;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class HelloMain implements QuarkusApplication {
   private static final Logger LOG = Logger.getLogger(HelloMain.class);

   @Inject
   private BattlenetService battlenetService;

   @Inject
   private HeroService heroService;

   @Override
   public int run(String... args) throws Exception {
      LOG.info("start job!");

      // 1.battlenetからヒーロー情報を取得
      List<Hero> fromBattlenet = this.battlenetService.getHeros();
      // fromBattlenet.remove(fromBattlenet.get(0));
      // 2.ヒーロー情報を洗い替える
      this.heroService.updateFromBattlenet(fromBattlenet);

      LOG.info("end job");

      return 0;
   }

}
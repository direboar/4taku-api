package yontaku.batch;

import java.util.List;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import yontaku.entity.Hero;
import yontaku.service.BattlenetService;
import yontaku.service.HeroService;

@QuarkusMain
public class UpdateHeroBatch implements QuarkusApplication {
   private static final Logger LOG = Logger.getLogger(UpdateHeroBatch.class);

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
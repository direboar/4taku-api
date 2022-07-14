package yontaku.batch;

import java.util.List;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import picocli.CommandLine;
import yontaku.entity.MinderRanking;
import yontaku.service.MinderRankingService;
import yontaku.utils.MinderRankingExternalService;

//FIXME Heroの関連を維持したまま更新する
@CommandLine.Command(name = "get-minder-ranking", description = "get-minder-ranking")
// @QuarkusMain(name="get-minder-ranking")
public class GetMinderRankingCommand implements Runnable {
    private static final Logger LOG = Logger.getLogger(GetMinderRankingCommand.class);

    @Inject
    private MinderRankingExternalService minderRankingExternalService;
    @Inject
    private MinderRankingService minderRankingService;

    // @Inject
    // private HeroService heroService;
    // dbaccessを伴うコマンドならエラーにならない模様。。
    @Override
    public void run() {
        LOG.info("start job!");

        // this.minderRankingRepository.purge();
        List<MinderRanking> rankings = this.minderRankingExternalService.getMinderRanking();
        // rankings.forEach(ranking -> {
        this.minderRankingService.updateMinderRanking(rankings);
        // this.minderRankingRepository.save(ranking);
        // });
        LOG.info(rankings.size());
        LOG.info("end job!!!");
        LOG.info(rankings.size());
    }

}

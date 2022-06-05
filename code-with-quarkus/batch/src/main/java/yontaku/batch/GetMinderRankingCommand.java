package yontaku.batch;

import java.util.List;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import picocli.CommandLine;
import yontaku.entity.MinderRanking;
import yontaku.service.MinderRankingRepository;
import yontaku.utils.MinderRankingService;

@CommandLine.Command(name = "get-minder-ranking", description = "get-minder-ranking")
// @QuarkusMain(name="get-minder-ranking")
public class GetMinderRankingCommand implements Runnable {
    private static final Logger LOG = Logger.getLogger(UpdateHeroBatch.class);

    @Inject
    private MinderRankingService minderRankingService;

    @Inject
    private MinderRankingRepository minderRankingRepository;

    // @Inject
    // private HeroService heroService;
    // dbaccessを伴うコマンドならエラーにならない模様。。
    @Override
    public void run() {
        LOG.info("start job!");

        this.minderRankingRepository.purge();
        List<MinderRanking> rankings = this.minderRankingService.getMinderRanking();
        rankings.forEach(ranking -> {
            this.minderRankingRepository.save(ranking);
        });
        LOG.info("end job!");
    }

}

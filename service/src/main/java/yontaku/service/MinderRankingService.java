package yontaku.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import yontaku.entity.MinderRanking;

@ApplicationScoped
public class MinderRankingService {

    @Inject
    private MinderRankingRepository repository;

    @Transactional
    public void updateMinderRanking(List<MinderRanking> latests) {
        List<MinderRanking> fromDb = repository.getAll();
        // 1.minderRankingを検索
        Map<String, MinderRanking> fromDbMap = toMap(fromDb);
        Map<String, MinderRanking> latestsMap = toMap(latests);

        // 2.db未登録のデータを抽出して論理削除する。
        List<MinderRanking> removedList = new ArrayList<>();
        fromDbMap.entrySet().forEach(kv -> {
            if (!latestsMap.containsKey(kv.getKey())) {
                MinderRanking removed = fromDbMap.get(kv.getKey());
                removed.setInvalid(true);
                removedList.add(removed);
            }
        });
        removedList.forEach(removed -> {
            fromDbMap.remove(removed.getId());
        });

        // 3.minderRankingのデータを更新する。
        latestsMap.entrySet().forEach(kv -> {
            if (fromDbMap.containsKey(kv.getKey())) {
                // update
                MinderRanking rankingLatetsts = latestsMap.get(kv.getKey());
                MinderRanking rankingFromDb = fromDbMap.get(kv.getKey());
 
                rankingFromDb.setRanking(rankingLatetsts.getRanking());
                rankingFromDb.setCoinCurve1(rankingLatetsts.getCoinCurve1());
                rankingFromDb.setCoinCurve2(rankingLatetsts.getCoinCurve2());
                rankingFromDb.replaceDetail(rankingLatetsts.getDetails());
                rankingFromDb.setInvalid(false);
                this.repository.merge(rankingFromDb);
                
            } else {
                MinderRanking rankingLatetsts = latestsMap.get(kv.getKey());
                rankingLatetsts.setInvalid(false);
                this.repository.persist(rankingLatetsts);
            }
        });
    }

    private Map<String, MinderRanking> toMap(List<MinderRanking> list) {
        return list.stream().collect(Collectors.toMap(v -> v.getMinderRankingHeroName(), v -> v));
    }
}

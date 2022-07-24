package yontaku.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import yontaku.entity.DeckTrackerHeroNameMapping;
import yontaku.entity.Hero;
import yontaku.entity.MinderRanking;
import yontaku.entity.MinderRankingDetail;
import yontaku.rest.dto.MinderRankingView;

@Mapper(componentModel = "cdi")
public interface MinderRankingMapper {

    // TierTable更新リクエストをTierTableEntityにマッピング。
    @Mapping(target = "minderRankingHeroName", source = "minderRanking.minderRankingHeroName")
    @Mapping(target = "ranking", source = "minderRanking.ranking")
    @Mapping(target = "coinCurve1", source = "minderRanking.coinCurve1")
    @Mapping(target = "coinCurve2", source = "minderRanking.coinCurve2")
    @Mapping(target = "name", source = "hero.name")
    @Mapping(target = "displayName", source = "hero.displayName")
    @Mapping(target = "imageURL", source = "hero.imageURL")
    @Mapping(target = "deckTrackerHeroName", source = "deckTrackerHeroNameMapping.deckTrackerHeroName")
    MinderRankingView minderRankingToMinderRankingView(MinderRanking minderRanking,Hero hero,DeckTrackerHeroNameMapping deckTrackerHeroNameMapping);

    MinderRankingView.MinderRankingDetail minderRankingDetailToMinderRankingDetailView(MinderRankingDetail detail);

}

package yontaku.rest.mapper;

import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import yontaku.entity.Account;
import yontaku.entity.DeckTrackerHeroNameMapping;
import yontaku.entity.Hero;
import yontaku.entity.HeroEvaluation;
import yontaku.entity.HeroEvaluation.Ban;
import yontaku.entity.MinionType;
import yontaku.entity.Tier;
import yontaku.entity.TierTable;
import yontaku.rest.dto.TierTableListView;
import yontaku.rest.dto.TierTableRestView;
import yontaku.rest.dto.TierTableUpdateRequest;
import yontaku.service.AccountService;
import yontaku.service.MinionTypeService;

@Mapper(componentModel = "cdi")
public abstract class TierTableMapper {

    @Inject
    private AccountService accountService;

    @Inject
    private MinionTypeService minionTypeService;

    // TierTable更新リクエストをTierTableEntityにマッピング。
    @Mapping(target = "owner", source = "tierTable.ownerid")
    public abstract TierTable restTierTableUpdateRequestToTierTable(TierTableUpdateRequest tierTable);
    public Account accountIdToAccountEntity(int ownerid) {
        return this.accountService.getAccountById(ownerid);
    }

    @Mapping(target = "heroEvaluation", source = "tier.heros")
    public abstract Tier restTierTableUpdateRequestToTierTable(TierTableUpdateRequest.Tier tier);

    public HeroEvaluation heroToHeroEvaluationEntity(TierTableUpdateRequest.Hero hero) {
        HeroEvaluation heroEvaluation = new HeroEvaluation();
        // heroEvaluation.setId(hero.getId());
        heroEvaluation.setMemo(hero.getMemo());
        heroEvaluation.setId(hero.getEvaluationId());
        heroEvaluation.setBan(banToBanEntity(hero.getBan()));
        heroEvaluation.setEvaluationOrder(hero.getEvaluationOrder());
        Hero heroEntity = this.heroToHeroEntity(hero);
        heroEvaluation.setHero(heroEntity);
        return heroEvaluation;
    }
    public abstract Hero heroToHeroEntity(TierTableUpdateRequest.Hero hero);
    public abstract HeroEvaluation.Ban banToBanEntity(TierTableUpdateRequest.Ban ban);

    // TierTableEntityをTierTable取得時のレスポンスにマッピング。
    public TierTableRestView entityHeroToTierTableRestView(TierTable tierTable) {
        return entityHeroToTierTableRestView(tierTable, tierTable.getOwner());
    }

    @Mapping(target = "id", source = "tierTable.id")
    @Mapping(target = "name", source = "tierTable.name")
    @Mapping(target = "ownerid", source = "owner.id")
    public abstract TierTableRestView entityHeroToTierTableRestView(TierTable tierTable, Account owner);

    @Mapping(target = "heros", source = "tier.heroEvaluation")
    public abstract TierTableRestView.Tier entityTierToTierRestView(Tier tier);
    public TierTableRestView.Hero entityTierToTierRestView(HeroEvaluation heroEvaluation) {
        return entityTierToTierRestView(heroEvaluation, heroEvaluation.getHero(),
                heroEvaluation.getHero().getDeckTrackerHeroNameMapping());
    }

    @Mapping(target = "deckTrackerHeroName", source = "deckTrackerHeroNameMapping.deckTrackerHeroName")
    @Mapping(target = "id", source = "hero.id")
    @Mapping(target = "evaluationId", source = "heroEvaluation.id")
    @Mapping(target = "name", source = "hero.name")
    @Mapping(target = "displayName", source = "hero.displayName")
    @Mapping(target = "imageURL", source = "hero.imageURL")
    @Mapping(target = "evaluationOrder", source = "heroEvaluation.evaluationOrder")
    @Mapping(target = "ban", source = "heroEvaluation.ban")
    @Mapping(target = "memo", source = "heroEvaluation.memo")
    public abstract TierTableRestView.Hero entityTierToTierRestView(HeroEvaluation heroEvaluation, Hero hero,
            DeckTrackerHeroNameMapping deckTrackerHeroNameMapping);

    //FIXME トランザクション外で変換しているので、一時キャッシュが有効にならない。
    //      トランザクション境界に処理を持ち込むか、BanをテーブルにしてMinionTypeとの関連をEntityのリレーションで扱う。
    //      二次キャッシュとする案もあるが、バッチ処理完了後にトリガーをもらってキャッシュリフレッシュする必要がありちょっと面倒。
    public TierTableRestView.Ban entityBanToBanRestView(Ban ban) {
        Map<Integer, MinionType> minionTypesFromDB = this.minionTypeService.getAll().stream()
                .collect(Collectors.toMap(item -> item.getId(), item -> item));
        TierTableRestView.Ban retVal = new TierTableRestView.Ban();

        ban.getExists().forEach(minionTypeID -> {
            MinionType minionType = minionTypesFromDB.get(minionTypeID);
            retVal.getExists().add(entityTierToTierRestView(minionType));
        });
        ban.getNotExists().forEach(minionTypeID -> {
            MinionType minionType = minionTypesFromDB.get(minionTypeID);
            retVal.getNotExists().add(entityTierToTierRestView(minionType));
        });
        return retVal;
    }
    public abstract TierTableRestView.MinionType entityTierToTierRestView(MinionType minionType);

    //一覧検索用のRestViewへの変換
    @Mapping(target = "id", source = "tierTable.id")
    @Mapping(target = "name", source = "tierTable.name")
    @Mapping(target = "updatedAt", source = "tierTable.updatedAt")
    @Mapping(target = "ownerid", source = "owner.id")
    @Mapping(target = "ownerName", source = "owner.name")
    public abstract TierTableListView tierTableAndAccountToTierTableListView(TierTable tierTable, Account owner);
}

package yontaku.rest.mapper;

import javax.inject.Inject;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

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

@Mapper(componentModel = "cdi")
public abstract class TierTableMapper {

    @Inject
    private AccountService accountService;

    // ---- TierTable更新リクエストをTierTableEntityにマッピング。---- //
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
        heroEvaluation.setHeroMemoURL(hero.getHeroMemoURL());
        Hero heroEntity = this.heroToHeroEntity(hero);
        heroEvaluation.setHero(heroEntity);
        return heroEvaluation;
    }
    public abstract Hero heroToHeroEntity(TierTableUpdateRequest.Hero hero);
    public abstract HeroEvaluation.Ban banToBanEntity(TierTableUpdateRequest.Ban ban);

    // ---- TierTableEntityをTierTable取得時のレスポンスにマッピング。 ---- //
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
    @Mapping(target = "heroMemoURL", source = "heroEvaluation.heroMemoURL")
    public abstract TierTableRestView.Hero entityTierToTierRestView(HeroEvaluation heroEvaluation, Hero hero,
            DeckTrackerHeroNameMapping deckTrackerHeroNameMapping);

    /** 
     * EntityのBANをREST返却形式のBANに返却する。
     * なお、ここではデータ構造をEntityのBANに変換するが、MinionTypeのコピー処理ではここでは行わずに外部で実施する。
     * このメソッドは都度呼び出されるが、このメソッドは現状トランザクション外で呼び出されるため、JPAの一時キャッシュが有効にならず、DBへの都度アクセスが発生するため。
     * そのため一旦、ResourceクラスでまとめてMinionTypeの取得を行った後で後で補完するようにしている。
     * トランザクション境界をリソースクラスにしたほうが良いかも。データ変換をサービス層に持っていく案もある。
     * @param ban
     * @return Ban
     */
    public TierTableRestView.Ban entityBanToBanRestView(Ban ban) {
        TierTableRestView.Ban retVal = new TierTableRestView.Ban();

        ban.getRequired().forEach(minionTypeID -> {
            TierTableRestView.MinionType minionType = new TierTableRestView.MinionType();
            minionType.setId(minionTypeID);
            retVal.getRequired().add(minionType);
        });
        ban.getDesierd().forEach(minionTypeID -> {
            TierTableRestView.MinionType minionType = new TierTableRestView.MinionType();
            minionType.setId(minionTypeID);
            retVal.getDesierd().add(minionType);
        });
        ban.getNeedless().forEach(minionTypeID -> {
            TierTableRestView.MinionType minionType = new TierTableRestView.MinionType();
            minionType.setId(minionTypeID);
            retVal.getNeedless().add(minionType);
        });
        return retVal;
    }
    public abstract TierTableRestView.MinionType entityTierToTierRestView(MinionType minionType);

    public abstract void updateMinionType(MinionType minionType, @MappingTarget TierTableRestView.MinionType target);
        
    //一覧検索用のRestViewへの変換
    @Mapping(target = "id", source = "tierTable.id")
    @Mapping(target = "name", source = "tierTable.name")
    @Mapping(target = "updatedAt", source = "tierTable.updatedAt")
    @Mapping(target = "ownerid", source = "owner.id")
    @Mapping(target = "ownerName", source = "owner.name")
    public abstract TierTableListView tierTableAndAccountToTierTableListView(TierTable tierTable, Account owner);
}

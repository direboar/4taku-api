package yontaku.rest.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.commons.beanutils.BeanUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import yontaku.entity.Hero;
import yontaku.entity.MinionType;
import yontaku.entity.TierTable;
import yontaku.rest.dto.TierTableRestView;
import yontaku.rest.dto.TierTableUpdateRequest;
import yontaku.service.HeroService;
import yontaku.service.MinionTypeService;

@Mapper(componentModel = "cdi")
public abstract class TierTableMapper {

    @Inject
    private HeroService heroService;

    @Inject
    private MinionTypeService minionTypeService;

    // TierTable更新リクエストをTierTableEntityにマッピング。
    public abstract TierTable restTierTableUpdateRequestToTierTable(TierTableUpdateRequest tierTable);

    // TierTableEntityをTierTable取得時のレスポンスマッピング。
    public abstract TierTableRestView entityHeroToTierTableRestView(TierTable tierTable);

    // entityHeroToTierTableRestViewメソッドで、idをMinionTypeにマッピング。
    public abstract TierTableRestView.MinionType idToMinionType(Integer id);

    // マッピング後に実行したいメソッド
    // HeroおよびMinionTypeの属性を展開し、コピーする。
    @AfterMapping
    protected void after(@MappingTarget TierTableRestView tierTableRestView) {
        Map<Integer, Hero> herosFromDb = this.heroService.getAll().stream()
                .collect(Collectors.toMap(item -> item.getId(), item -> item));
        Map<Integer, MinionType> minionTypesFromDB = this.minionTypeService.getAll().stream()
                .collect(Collectors.toMap(item -> item.getId(), item -> item));

        tierTableRestView.getTiers().forEach(tier -> {
            tier.getHeros().forEach(hero -> {
                Hero heroFromDb = herosFromDb.get(hero.getId());
                this.copy(hero, heroFromDb);

                hero.getBan().getExists().forEach(minionType -> {
                    copyMinionType(minionTypesFromDB, minionType);
                });
                hero.getBan().getNotExists().forEach(minionType -> {
                    copyMinionType(minionTypesFromDB, minionType);
                });
            });
        });
    }

    private void copyMinionType(Map<Integer, MinionType> minionTypesFromDB,
            yontaku.rest.dto.TierTableRestView.MinionType minionType) {
        // FIXME 未選択のMinionTypeをここで追加する。

        MinionType minionTypeFromDb = minionTypesFromDB.get(minionType.getId());
        this.copy(minionType, minionTypeFromDb);
    }

    private void copy(Object dest, Object src) {
        try {
            BeanUtils.copyProperties(dest, src);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}

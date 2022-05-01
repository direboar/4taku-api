package org.acme.rest.json.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.entity.Hero;
import org.acme.entity.TierTable;
import org.acme.rest.json.TierTableRestView;
import org.acme.rest.json.TierTableUpdateRequest;
import org.acme.service.HeroService;
import org.apache.commons.beanutils.BeanUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public abstract class TierTableMapper {

    @Inject
    private HeroService heroService;

    public abstract TierTable restTierTableUpdateRequestToTierTable(TierTableUpdateRequest tierTable);

    // Hero restHeroToEntityHero(TierTableUpdateRequest.Hero hero);

    public abstract TierTableRestView entityHeroToTierTableRestView(TierTable tierTable);

    // マッピング後に実行したいメソッド
    @AfterMapping
    protected void after(@MappingTarget TierTableRestView tierTableRestView) {
        Map<Integer, Hero> herosFromDb = this.heroService.getAll().stream()
                .collect(Collectors.toMap(item -> item.getId(), item -> item));

        tierTableRestView.getTiers().forEach(tier -> {
            tier.getHeros().forEach(hero -> {
                Hero heroFromDb = herosFromDb.get(hero.getId());
                try {
                    BeanUtils.copyProperties(hero, heroFromDb);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }

}

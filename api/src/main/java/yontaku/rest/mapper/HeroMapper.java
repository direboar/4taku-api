package yontaku.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import yontaku.entity.Hero;
import yontaku.rest.dto.HeroRestView;

// @Mapper(componentModel = "cdi")
@Mapper(componentModel = "cdi", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface HeroMapper {

    public HeroRestView accountRestViewToAccount(Hero hero);

}

package org.acme.rest.json.mapper;

import org.acme.entity.Account;
import org.acme.entity.TierTable;
import org.acme.rest.json.AccountRestView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

// @Mapper(componentModel = "cdi")
@Mapper(componentModel = "cdi", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface AccountMapper {

    @Mapping(target = "tierTableName", source = "tiertable.name")
    @Mapping(target = "id", source = "account.id")
    @Mapping(target = "name", source = "account.name")
    @Mapping(target = "tierTableId", source = "account.tierTableId")
    public AccountRestView accountAndTierTableToAccountRestView(Account account, TierTable tiertable);

    public AccountRestView accountToAccountRestView(Account account);

    public Account AccountRestViewToAccount(AccountRestView accountRestView);

}

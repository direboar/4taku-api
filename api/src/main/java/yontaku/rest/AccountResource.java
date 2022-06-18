package yontaku.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.security.Authenticated;
import yontaku.entity.Account;
import yontaku.entity.TierTable;
import yontaku.rest.dto.AccountRestView;
import yontaku.rest.mapper.AccountMapper;
import yontaku.service.AccountService;
import yontaku.service.TierTableService;

@Authenticated
@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class AccountResource {

    @Inject
    private AccountService accountService;

    @Inject
    private TierTableService tierTableService;

    @Inject
    private AccountMapper accountMapper;

    @GET
    public AccountRestView init(){
        Account account = this.accountService.getOrInitializeAccount();
        TierTable tierTable = null;
        
        if(account.getTierTableId() != null){
            tierTable = this.tierTableService.get(account.getTierTableId());
        }
        return tierTable == null ?
               this.accountMapper.accountToAccountRestView(account):
               this.accountMapper.accountAndTierTableToAccountRestView(account, tierTable);
    }

    @POST
    public Response save(AccountRestView accountRestView){
        Account account = this.accountService.getAccount();
        Account updateRequest = this.accountMapper.AccountRestViewToAccount(accountRestView);

        //更新項目を反映する。
        account.setName(updateRequest.getName());
        account.setTierTableId(updateRequest.getTierTableId());
        account = this.accountService.update(account);

        return Response.ok().build();
    }
}

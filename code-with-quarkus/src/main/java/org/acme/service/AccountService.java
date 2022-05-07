package org.acme.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.acme.entity.Account;

import io.quarkus.oidc.UserInfo;
import io.quarkus.security.identity.SecurityIdentity;

@ApplicationScoped
public class AccountService {
    
    @Inject
    private EntityManager entityManager;

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    UserInfo userInfo;

    @Transactional
    public Account getOrInitializeAccount(){
        Account account = this.getAccount();
        if(account == null){
            account = this.createDefaultAccount();
        }
        return account;
    }

    @Transactional
    public Account update(Account account){
        return this.entityManager.merge(account);
    }

    public Account getAccount(){
        String oiceUserName = this.securityIdentity.getPrincipal().getName();
        return this.entityManager.find(Account.class, oiceUserName);
    }

    private Account createDefaultAccount(){
        String oicdUserName = this.securityIdentity.getPrincipal().getName();
        Account account = new Account();
        account.setOicdUserName(oicdUserName);
        account.setName(this.userInfo.getString("name")); //fixme
        account.setTierTableId(null);
        this.entityManager.persist(account);
        return account;
    }
}

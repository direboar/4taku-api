package org.acme.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        String oicdUserName = this.securityIdentity.getPrincipal().getName();
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);
        query.select(root).where(builder.equal(root.get("oicdUserName"), oicdUserName));
        try{
            return entityManager.createQuery(query).getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    private Account createDefaultAccount(){
        String oicdUserName = this.securityIdentity.getPrincipal().getName();
        Account account = new Account();
        account.setOicdUserName(oicdUserName);
        // account.setName(this.userInfo.getString("name")); //fixme
        account.setTierTableId(null);
        this.entityManager.persist(account);
        return account;
    }
}

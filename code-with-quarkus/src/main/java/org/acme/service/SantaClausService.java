package org.acme.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class SantaClausService {
    @Inject
    EntityManager em; 

    @Transactional 
    public void createGift(String giftDescription) {
        Gift gift = new Gift();
        gift.setName(giftDescription);
        em.persist(gift);
    }

    @Transactional 
    public List<Gift> selectGifts() {
        CriteriaQuery<Gift> query = this.em.getCriteriaBuilder().createQuery(Gift.class);
        query.select(query.from(Gift.class));
        List<Gift> ret =  em.createQuery(query).getResultList();
        System.out.println(ret);
        return ret;
    }

}
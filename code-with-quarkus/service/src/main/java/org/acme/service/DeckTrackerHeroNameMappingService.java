package org.acme.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.acme.entity.DeckTrackerHeroNameMapping;

@ApplicationScoped
public class DeckTrackerHeroNameMappingService {

    @Inject
    private EntityManager entityManager;

    public List<DeckTrackerHeroNameMapping> getAll(){
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<DeckTrackerHeroNameMapping> query = builder.createQuery(DeckTrackerHeroNameMapping.class);
        Root<DeckTrackerHeroNameMapping> root = query.from(DeckTrackerHeroNameMapping.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    } 

}

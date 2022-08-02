package yontaku.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import yontaku.entity.MinderRanking;
import yontaku.utils.AuditableUtls;

@ApplicationScoped
public class MinderRankingRepository {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public void persist(MinderRanking minderRanking) {
        AuditableUtls.updateTimestamp(minderRanking);
        this.entityManager.persist(minderRanking);
    }

    @Transactional
    public void merge(MinderRanking minderRanking) {
        AuditableUtls.updateTimestamp(minderRanking);
        this.entityManager.merge(minderRanking);
        this.entityManager.flush();
    }

    @Transactional
    public void delete(MinderRanking minderRanking) {
        this.entityManager.remove(minderRanking);
    }

    @Transactional
    public void purge(){
        this.getAllValid().forEach(minderRanking->{
            this.delete(minderRanking);
        });
    }

    // hero,deckTrackerHeroNameMappingを全てFetchJoinして返却する。
    public List<MinderRanking> getAllValid() {
        Query query = entityManager.createQuery(
            "SELECT m FROM MinderRanking m "+ 
            "INNER JOIN FETCH m.hero as h " + 
            "INNER JOIN FETCH h.deckTrackerHeroNameMapping " + 
            "WHERE m.invalid = false");
        return query.getResultList();
    }

    public List<MinderRanking> getAll() {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<MinderRanking> query = builder.createQuery(MinderRanking.class);
        Root<MinderRanking> root = query.from(MinderRanking.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

}

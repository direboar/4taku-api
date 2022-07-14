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

@ApplicationScoped
public class MinderRankingRepository {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public void save(MinderRanking minderRanking) {
        this.entityManager.persist(minderRanking);
    }

    @Transactional
    public void delete(MinderRanking minderRanking) {
        this.entityManager.remove(minderRanking);
    }

    @Transactional
    public void deleteDetails(MinderRanking minderRanking) {
        minderRanking.getDetails().forEach(detail->{
            this.entityManager.remove(detail);
        });
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

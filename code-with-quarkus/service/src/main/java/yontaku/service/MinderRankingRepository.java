package yontaku.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
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
    public void purge(){
        this.getAll().forEach(minderRanking->{
            this.delete(minderRanking);
        });
    }

    // 全件検索
    public List<MinderRanking> getAll() {
        CriteriaQuery<MinderRanking> query = this.entityManager.getCriteriaBuilder().createQuery(MinderRanking.class);
        query.select(query.from(MinderRanking.class));
        return entityManager.createQuery(query).getResultList();
    }

}

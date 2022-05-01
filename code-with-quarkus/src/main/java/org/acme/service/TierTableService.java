package org.acme.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.acme.entity.TierTable;

@ApplicationScoped
public class TierTableService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public int save(TierTable tierTable) {
        //HeroはJSONに永続化しないので参照を削除する。
        // this.deleteHeroObject(tierTable);
        TierTable updated = this.entityManager.merge(tierTable);
        return updated.getId();
    }

    public TierTable get(int id) {
        return this.entityManager.find(TierTable.class, id);
    }

    @Transactional
    public void delete(int id) {
        TierTable entity = this.get(id);
        if(entity != null){
            this.entityManager.remove(entity);
        }
    }

    // 全件検索
    public List<TierTable> getAll() {
        CriteriaQuery<TierTable> query = this.entityManager.getCriteriaBuilder().createQuery(TierTable.class);
        query.select(query.from(TierTable.class));
        return entityManager.createQuery(query).getResultList();
    }

    public int getTotalCount() {
        Query query = entityManager.createNativeQuery("SELECT COUNT(*) FROM TIERTABLE");
        int count = ((Number) query.getSingleResult()).intValue();
        return count;
    }

    public List<TierTable> getAllByPaging(int offset, int limit) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<TierTable> query = builder.createQuery(TierTable.class);
        Root<TierTable> root = query.from(TierTable.class);
        query.multiselect(root.get("id"), root.get("name"));
        // query.select(root);
        return entityManager.createQuery(query).setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    // private void deleteHeroObject(TierTable tierTable) {
    //     if (tierTable.getTiers() == null)
    //         return;
    //     tierTable.getTiers().forEach((tier -> {
    //         tier.setHeros(null);
    //     }));
    // }
}
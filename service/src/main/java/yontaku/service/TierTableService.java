package yontaku.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.oidc.UserInfo;
import io.quarkus.security.identity.SecurityIdentity;
import yontaku.entity.TierTable;

@ApplicationScoped
public class TierTableService {

    @Inject
    private EntityManager entityManager;

    @Inject
    private UserInfo userInfo;

    @Inject
    private JsonWebToken jwt;

    @Inject
    SecurityIdentity securityIdentity;

    @Transactional
    public int save(TierTable tierTable) {
        TierTable fromDb = null;

        //DBに登録済みのHeroEvaluationが、更新対象のTier表から削除されている場合は、対象のHeroEvaluationをDBから削除する。
        //Tier->HeroEvaluationは、orphanRemoval=falseのため削除されないための措置。
        //なお、orphanRemoval=trueとした場合、HeroEvaluationがリストから削除されたことを持ってDelete文が発行される関係で、親子関係の付け替えが正しく動作しない。
        //そのため、このような設計としている。
        //なお、TierTable->TierはorphanRemoval=tureのためそのような処理は不要。
        if(tierTable.getId() != null){
            fromDb = this.entityManager.find(TierTable.class, tierTable.getId());
            fromDb.getAllHeroEvaluation().forEach(he->{
                if(!tierTable.containsHeroEvaluationByHero(he)){
                    this.entityManager.remove(he);
                }                
            });
        }
        
        //更新対象のTierTableをマージする。（HeroEvaluationはCascadeでマージされる。）
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        LocalDateTime updatedAt = now.toLocalDateTime();
        tierTable.setUpdatedAt(updatedAt);
        TierTable mergedTierTable = this.entityManager.merge(tierTable);

        return mergedTierTable.getId();
    }

    public TierTable get(int id) {
        Query query = entityManager.createQuery(
                "SELECT tt FROM TierTable tt " +
                        "LEFT OUTER JOIN FETCH tt.tiers as t " +
                        "LEFT OUTER JOIN FETCH t.heroEvaluations as he " +
                        "LEFT OUTER JOIN FETCH he.hero as hero " +
                        "LEFT OUTER JOIN FETCH hero.deckTrackerHeroNameMapping " +
                        "WHERE tt.id = :id " +
                        "ORDER BY t.tableOrder");
        query.setParameter("id", id);
        return TierTable.class.cast(query.getSingleResult());
    }

    @Transactional
    public void delete(int id) {
        TierTable entity = this.get(id);
        if (entity != null) {
            this.entityManager.remove(entity);
        }
    }

    // 全件検索
    public List<TierTable> getAll() {
        CriteriaQuery<TierTable> query = this.entityManager.getCriteriaBuilder().createQuery(TierTable.class);
        query.select(query.from(TierTable.class));
        return entityManager.createQuery(query).getResultList();
    }

    public int getTotalCount(boolean owner, int accountId) {
        String jpql = "SELECT count(t) FROM TierTable t " +
                "INNER JOIN t.owner as o ";

        if (owner) {
            jpql += "WHERE o.id = :accountId ";
        }
        Query query = entityManager.createQuery(jpql);
        if (owner) {
            query.setParameter("accountId", accountId);
        }
        int count = ((Number) query.getSingleResult()).intValue();
        return count;
    }

    public List<TierTable> getAllByPaging(int offset, int limit, boolean owner, int accountId) {
        String jpql = "SELECT t FROM TierTable t " +
                "INNER JOIN FETCH t.owner as o ";

        if (owner) {
            jpql += "WHERE o.id = :accountId ";
        }
        jpql += "ORDER BY t.updatedAt DESC";
        Query query = entityManager.createQuery(jpql);
        if (owner) {
            query.setParameter("accountId", accountId);
        }
        query.setMaxResults(limit);
        query.setFirstResult(offset);
        return query.getResultList();
    }

}
package org.acme.service;

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

import org.acme.entity.TierTable;
import org.acme.entity.dto.TierTablePagingDto;
import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.oidc.UserInfo;
import io.quarkus.security.identity.SecurityIdentity;

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
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        LocalDateTime updatedAt = now.toLocalDateTime();
        tierTable.setUpdatedAt(updatedAt);
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

    // public List<TierTable> getAllByPaging(int offset, int limit) {
    //     CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
    //     CriteriaQuery<TierTable> query = builder.createQuery(TierTable.class);
    //     Root<TierTable> root = query.from(TierTable.class);
    //     query.multiselect(root.get("id"), root.get("name"));
    //     return entityManager.createQuery(query).setFirstResult(offset).setMaxResults(limit).getResultList();
    // }

    public List<TierTablePagingDto> getAllByPaging(int offset, int limit) {
        String sql = 
          "SELECT " +  
          " A.ID, A.NAME, A.OWNERID , A.UPDATEDAT , B.NAME AS OWNERNAME " +
          " FROM TIERTABLE AS A " +
          "  INNER JOIN ACCOUNT AS B " +
          "  ON A.OWNERID = B.ID " +
          "  ORDER BY UPDATEDAT DESC" +
          "  LIMIT " + limit + " " +
          "  OFFSET " + offset + " ";
        Query query = this.entityManager.createNativeQuery(sql,"TierTablePagingDtoMapping");
        return query.getResultList();
    }

}
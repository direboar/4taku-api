package yontaku.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import yontaku.entity.MinionType;

@ApplicationScoped
public class MinionTypeService {
 
    @Inject
    private EntityManager entityManager;

    public List<MinionType> getAll(){
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<MinionType> query = builder.createQuery(MinionType.class);
        Root<MinionType> root = query.from(MinionType.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

}

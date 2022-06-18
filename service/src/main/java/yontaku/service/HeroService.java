package yontaku.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import yontaku.entity.Hero;

@ApplicationScoped
public class HeroService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public void save(List<Hero> heros){
        heros.forEach((hero->{
            entityManager.persist(hero);
        }));
    }

    @Transactional
    public void updateFromBattlenet(List<Hero> fromBattlenet){
        //1.battlenetからヒーロー情報を取得
        Map<Integer,Hero> herosFromBattlenet =toMap(fromBattlenet);
        //2.DB登録済みのヒーロー情報を取得
        Map<Integer,Hero> herosFromDB =toMap(this.getAll());

        //3.DB登録済みで、Battlenet未登録のデータを抽出して論理削除する。
        List<Hero> removedList = new ArrayList<>();
        herosFromDB.entrySet().forEach(kv->{
            if(!herosFromBattlenet.containsKey(kv.getKey())){
                Hero removed = herosFromDB.get(kv.getKey());
                removed.setInvalid(true);
                removedList.add(removed);
            }
        });
        removedList.forEach(removed ->{herosFromDB.remove(removed.getBattlenetId());});

        //4.Battlenet登録済のデータを更新する。
        herosFromBattlenet.entrySet().forEach(kv->{
            if(herosFromDB.containsKey(kv.getKey())){
                //update
                Hero heroFromBattlenet = herosFromBattlenet.get(kv.getKey());
                Hero heroFromDb = herosFromDB.get(kv.getKey());

                heroFromDb.setName(heroFromBattlenet.getName());
                heroFromDb.setDisplayName(heroFromBattlenet.getDisplayName());
                heroFromDb.setImageURL(heroFromBattlenet.getImageURL());
                this.entityManager.persist(heroFromDb);

            }else{
                Hero heroFromBattlenet = herosFromBattlenet.get(kv.getKey());
                this.entityManager.persist(heroFromBattlenet);
            }
        });

    }

    private Map<Integer,Hero> toMap(List<Hero> heros){
        return heros.stream().collect(Collectors.toMap(item->item.getBattlenetId(), item->item));
    }

    //全件検索
    public List<Hero> getAll(){
        CriteriaQuery<Hero> query = this.entityManager.getCriteriaBuilder().createQuery(Hero.class);
        query.select(query.from(Hero.class));
        return entityManager.createQuery(query).getResultList();
    }

    //invalid=falseを検索
    public List<Hero> getAllAlive(){
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Hero> query = builder.createQuery(Hero.class);
        Root<Hero> root = query.from(Hero.class);
        query.select(root).where(builder.equal(root.get("invalid"), false));
        return entityManager.createQuery(query).getResultList();
    }

}
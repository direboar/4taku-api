package yontaku.entity;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TierTableTest {

    @Inject
    private EntityManager entityManager;

    @Test
    @Transactional
    public void testInsert(){
        Account account = entityManager.find(Account.class, 0);

        TierTable tierTable = new TierTable();
        tierTable.setName("aaa");
        tierTable.setOwner(account);
        tierTable.setUpdatedAt(LocalDateTime.now());

        Tier tier = new Tier();
        tier.setName("tier1");
        tier.setColor("red");
        tier.setTableOrder(1);
        tierTable.getTiers().add(tier);

        Tier tier2 = new Tier();
        tier2.setName("tier2");
        tier2.setColor("blue");
        tier2.setTableOrder(2);
        tierTable.getTiers().add(tier2);

        HeroEvaluation heroEvaluation = new HeroEvaluation();
        Hero hero = entityManager.find(Hero.class, 59397);
        heroEvaluation.setMemo("memo");
        heroEvaluation.setBan(new HeroEvaluation.Ban());
        heroEvaluation.setHero(hero);
        tier.getHeroEvaluation().add(heroEvaluation);

        entityManager.persist(tierTable);
        entityManager.flush();

        TierTable found = entityManager.find(TierTable.class, tierTable.getId());
        System.out.println(found);

    }


    @Test
    @Transactional
    public void testInsert2(){

        TierTable tierTable = new TierTable();
        tierTable.setName("aaa");
        // tierTable.setOwnerid(1);
        tierTable.setUpdatedAt(LocalDateTime.now());

        Tier tier3 = new Tier();
        tier3.setName("tier3");
        tier3.setColor("blue");
        tier3.setTableOrder(2);
        tierTable.getTiers().add(tier3);

        HeroEvaluation heroEvaluation = new HeroEvaluation();
        Hero hero = new Hero();
        hero.setId(59397);
        heroEvaluation.setMemo("memo");
        heroEvaluation.setBan(new HeroEvaluation.Ban());
        heroEvaluation.setHero(hero);
        tier3.getHeroEvaluation().add(heroEvaluation);

        HeroEvaluation heroEvaluation2 = new HeroEvaluation();
        Hero hero2 =  new Hero();
        hero2.setId(57633);
        heroEvaluation2.setMemo("memo");
        heroEvaluation2.setBan(new HeroEvaluation.Ban());
        heroEvaluation2.setHero(hero2);
        tier3.getHeroEvaluation().add(heroEvaluation2);

        TierTable updatee = this.entityManager.find(TierTable.class, 20);
        updatee.getTiers();
        updatee.setName(tierTable.getName());
        // updatee.setOwnerid(tierTable.getOwnerid());
        updatee.setUpdatedAt(tierTable.getUpdatedAt());
        updatee.getTiers().clear();
        updatee.getTiers().addAll(tierTable.getTiers());

        entityManager.flush();
        TierTable found = entityManager.find(TierTable.class, updatee.getId());
        System.out.println(found);

    }

}
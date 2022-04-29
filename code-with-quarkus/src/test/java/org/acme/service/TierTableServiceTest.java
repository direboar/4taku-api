package org.acme.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.acme.entity.Tier;
import org.acme.entity.TierTable;
import org.acme.entity.TieredHero;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TierTableServiceTest {

    @Inject
    private TierTableService tierService;

    @Test
    public void testSave(){
        TierTable tierTable = new TierTable();
        tierTable.setName("ああああ");
        tierTable.setOwnerid(222);
        List<Tier> tiers = new ArrayList<>();
        tierTable.setTiers(tiers);
        Tier tier1 = new Tier();
        tiers.add(tier1);
        tier1.setColor("color");
        tier1.setName("S");
        tier1.setId("222");
        List<TieredHero> heros = new ArrayList<>();
        TieredHero hero1 = new TieredHero();
        heros.add(hero1);
        // hero1.setHeroId(1);
        // hero1.setHero(new Hero());
        // tier1.setHeros(heros);
        this.tierService.save(tierTable);

        List<TierTable> tables = this.tierService.getAll();
        assertEquals(1,tables.size());

        // assertEquals(tierTable,tables.get(0));
    }

    @Test
    public void testPaging(){
        assertEquals(this.tierService.getAllByPaging(0,2).size(),0);

        this.tierService.save(new TierTable(null,"11",1,null));
        assertEquals(this.tierService.getAllByPaging(0,2).size(),1);
        
        this.tierService.save(new TierTable(null,"11",1,null));
        assertEquals(this.tierService.getAllByPaging(0,2).size(),2);
        this.tierService.save(new TierTable(null,"11",1,null));
        assertEquals(this.tierService.getAllByPaging(0,2).size(),2);
        assertEquals(this.tierService.getAllByPaging(2,2).size(),1);
    }

}
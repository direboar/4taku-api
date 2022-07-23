package yontaku.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import yontaku.entity.Account;
import yontaku.entity.TierTable;
import yontaku.entity.json.Tier;

@QuarkusTest
public class TierTableResourceTest {

    @Inject
    private EntityManager em;

    @Inject
    private TierTableService service;

    @Inject
    private AccountService accountService;

    @Test
    public void testGet(){
        TierTable t = service.get(1);
        assertNotNull(t);
    }
    
    @Test
    @Transactional
    public void testSave(){
        Account account = accountService.getAccountById(0);

        // em.getTransaction().begin();
        TierTable t = new TierTable();
        t.setOwner(account);
        t.setName("aaa");
        Tier tier = new Tier();
        tier.setColor("red");
        tier.setName("xxxx");
        tier.setOrder(0);
        int id = this.service.save(t);
        em.flush();
        // em.getTransaction().commit();
    }

    @Test
    public void testSave2(){
        TierTable found = this.service.get(11);
        assertNotNull(found);
    }

}

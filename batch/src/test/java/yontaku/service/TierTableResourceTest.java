package yontaku.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;

// @QuarkusTest
public class TierTableResourceTest {

    @Inject
    private EntityManager em;

    @Inject
    private TierTableService service;

    @Inject
    private AccountService accountService;

    // @Test
    // public void testGet(){
    //     TierTable t = service.get(1);
    //     assertNotNull(t);
    // }
    
    // @Test
    // @Transactional
    // public void testSave(){
    //     Account account = accountService.getAccountById(0);

    //     // em.getTransaction().begin();
    //     TierTable t = new TierTable();
    //     t.setOwner(account);
    //     t.setName("aaa");
    //     Tier tier = new Tier();
    //     tier.setColor("red");
    //     tier.setName("xxxx");
    //     tier.setOrder(0);
    //     int id = this.service.save(t);
    //     em.flush();
    //     // em.getTransaction().commit();
    // }

    // @Test
    // public void testSave2(){
    //     TierTable found = this.service.get(11);
    //     assertNotNull(found);
    // }

}

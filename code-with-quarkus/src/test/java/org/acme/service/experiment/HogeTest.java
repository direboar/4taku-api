package org.acme.service.experiment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.acme.entity.MinionType;
import org.acme.service.MinionTypeService;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
// @QuarkusIntegrationTest
public class HogeTest {
    
    @Inject
    private MinionTypeService minionTypeService; 

    @Test
    public void test(){
        List<MinionType> minionTypes = this.minionTypeService.getAll();
        assertEquals(8,minionTypes);
    }
}

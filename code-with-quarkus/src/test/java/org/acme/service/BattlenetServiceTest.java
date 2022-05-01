package org.acme.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.google.inject.Inject;

import org.acme.entity.Hero;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class BattlenetServiceTest {
    
    @Inject
    private BattlenetService battlenetService;

    @Test
    public void test(){
        System.out.println("xx");
        List<Hero> heros = battlenetService.getHeros();
        assertNotNull(heros);
    }

}

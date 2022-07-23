package yontaku.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.inject.Inject;

import io.quarkus.test.junit.QuarkusTest;
import yontaku.entity.DeckTrackerHeroNameMapping;

@QuarkusTest
public class DeckTrackerHeroNameMappingServiceTest {
    @Inject
    private DeckTrackerHeroNameMappingService repository;

    // @Test
    public void test() {
        List<DeckTrackerHeroNameMapping> list = this.repository.getAll();
        assertTrue(list.size() > 0);
    }
}

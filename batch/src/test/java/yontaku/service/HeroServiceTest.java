package yontaku.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.inject.Inject;

import io.quarkus.test.junit.QuarkusTest;
import yontaku.entity.Hero;

//serviceプロジェクトに配置するとQuarkusTestが動作しない…。
@QuarkusTest
public class HeroServiceTest {

    @Inject
    private HeroService repository;

    // @Test
    public void test() {
        List<Hero> list = this.repository.getAll();
        assertTrue(list.size() > 0);
    }
}

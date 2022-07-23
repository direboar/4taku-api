package yontaku.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.inject.Inject;

import io.quarkus.test.junit.QuarkusTest;
import yontaku.entity.MinderRanking;

//serviceプロジェクトに配置するとQuarkusTestが動作しない…。
@QuarkusTest
public class MinderRankingRepositoryTest {

    @Inject
    private MinderRankingRepository repository;

    // @Test
    public void test() {
        List<MinderRanking> list = this.repository.getAllValid();
        assertTrue(list.size() > 0);
    }
}

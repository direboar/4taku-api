package yontaku.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class MinderRankingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minder_ranking_detail_sec")
    @SequenceGenerator(name = "minder_ranking_detail_sec", sequenceName = "minder_ranking_detail_sec", allocationSize = 1)
    private int id;

    private String minionType;

    private String ranking;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMinionType() {
        return minionType;
    }

    public void setMinionType(String minionType) {
        this.minionType = minionType;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

}

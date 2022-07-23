package yontaku.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class MinderRankingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minder_ranking_detail_sec")
    @SequenceGenerator(name = "minder_ranking_detail_sec", sequenceName = "minder_ranking_detail_sec", allocationSize = 1)
    private int id;

    private String minionType;

    private String ranking;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "rankingId")
    private MinderRanking minderRanking;

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

    public MinderRanking getMinderRanking() {
        return minderRanking;
    }

    public void setMinderRanking(MinderRanking minderRanking) {
        this.minderRanking = minderRanking;
    }

}

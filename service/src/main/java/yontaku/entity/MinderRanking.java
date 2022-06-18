package yontaku.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class MinderRanking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minder_ranking_seq")
    @SequenceGenerator(name = "minder_ranking_seq", sequenceName = "minder_ranking_seq", allocationSize = 1)
    private int id;

    private String heroName;

    private String ranking;

    private String coinCurve1;

    private String coinCurve2;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "rankingId")
    // @OneToMany(mappedBy = "minderRankingId", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<MinderRankingDetail> details;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getCoinCurve1() {
        return coinCurve1;
    }

    public void setCoinCurve1(String coinCurve1) {
        this.coinCurve1 = coinCurve1;
    }

    public String getCoinCurve2() {
        return coinCurve2;
    }

    public void setCoinCurve2(String coinCurve2) {
        this.coinCurve2 = coinCurve2;
    }

    public List<MinderRankingDetail> getDetails() {
        return details;
    }

    public void setDetails(List<MinderRankingDetail> details) {
        this.details = details;
    }


}

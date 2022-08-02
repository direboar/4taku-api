package yontaku.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class MinderRanking implements Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minder_ranking_seq")
    @SequenceGenerator(name = "minder_ranking_seq", sequenceName = "minder_ranking_seq", allocationSize = 1)
    private int id;

    private String minderRankingHeroName;

    private String ranking;

    private String coinCurve1;

    private String coinCurve2;

    private Boolean invalid;

    private LocalDateTime updatedAt;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.EAGER,mappedBy = "minderRanking") 
    private Set<MinderRankingDetail> details ;

    @OneToOne(fetch = FetchType.EAGER) //no cascade.
    @JoinColumn(name = "heroId")
    private Hero hero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMinderRankingHeroName() {
        return minderRankingHeroName;
    }

    public void setMinderRankingHeroName(String minderRankingHeroName) {
        this.minderRankingHeroName = minderRankingHeroName;
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

    public Set<MinderRankingDetail> getDetails() {
        return details;
    }

    public void setDetails(Set<MinderRankingDetail> details) {
        this.details = details;
        details.forEach(detail->{
            detail.setMinderRanking(this);
        });
    }
    public void addDetail(MinderRankingDetail detail) {
        this.details.add(detail);
        detail.setMinderRanking(this);
    }
    public void removeDetails(MinderRankingDetail detail) {
        this.details.remove(detail);
        detail.setMinderRanking(null);
    }

    public void replaceDetail(Set<MinderRankingDetail> details) {
        this.details.clear();
        this.details.addAll(details);
        this.details.forEach(detail->{
            detail.setMinderRanking(this);
        });
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


}

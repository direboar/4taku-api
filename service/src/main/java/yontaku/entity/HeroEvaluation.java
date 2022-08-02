package yontaku.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Entity
public class HeroEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hero_evaluation_seq")
    @SequenceGenerator(name = "hero_evaluation_seq", sequenceName = "hero_evaluation_seq", allocationSize = 1)
    private int id;

    @OneToOne(fetch = FetchType.EAGER) //no cascade.
    @JoinColumn(name = "heroId")
    private Hero hero;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "tierId")
    private Tier tier;

    @Column(columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private Ban ban;

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    private String memo;

    private String linkName;

    private String linkUrl;

    private int evaluationOrder;

    public int getId() {
        return id;
    }

    public int getEvaluationOrder() {
        return evaluationOrder;
    }

    public void setEvaluationOrder(int evaluationOrder) {
        this.evaluationOrder = evaluationOrder;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ban getBan() {
        return ban;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setBan(Ban ban) {
        this.ban = ban;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public boolean isNew(){
        return this.id == 0;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    @Getter 
    @Setter 
    @ToString
    public static class Ban{
        private List<Integer> required ;
        private List<Integer> desierd ;
        private List<Integer> needless ;
    }

}

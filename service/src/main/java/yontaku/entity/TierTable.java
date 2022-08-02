package yontaku.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class TierTable implements Auditable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tiertable_seq")
    @SequenceGenerator(name = "tiertable_seq", sequenceName = "tiertable_seq", allocationSize = 1)
    private Integer id;

    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ownerid")
    private Account owner;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY,mappedBy = "tierTable") 
    @OrderBy("tableOrder") //配列のソート順　@see http://terasolunaorg.github.io/guideline/public_review/ArchitectureInDetail/DataAccessJpa.html#id84
    private Set<Tier> tiers = new HashSet<>();

    private LocalDateTime updatedAt;

    public TierTable() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TierTable(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TierTable(Integer id, String name,  Set<Tier> tiers) {
        this.id = id;
        this.name = name;
        this.tiers = tiers;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Tier> getTiers() {
        return tiers;
    }

    public void setTiers(Set<Tier> tiers) {
        this.tiers = tiers;
        tiers.forEach(tier->{
            tier.setTierTable(this);
        });
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
    
    /** 
     * Tierに、指定したHeroEvaluationと同一のHeroEvaluationが、登録されているかを返却する。
     * なお同一性は、HeroEvaluationが保持するHeroで判定する。
     * @param heroEvaluation
     * @return boolean
     */
    public boolean containsHeroEvaluationByHero(HeroEvaluation heroEvaluation){
        return this.tiers.stream().map(tier->tier.containsHeroEvaluationByHero(heroEvaluation)).anyMatch(r->r==true);
    }
    
    /** 
     * Tierに所属するすべてのHeroEvaluationを返却する。
     * @return Set<HeroEvaluation>
     */
    public Set<HeroEvaluation> getAllHeroEvaluation(){
        return this.tiers.stream().map(tier->tier.getHeroEvaluation()).flatMap(Collection::stream).collect(Collectors.toSet());
    }

}

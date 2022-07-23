package yontaku.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;

@Entity
public class Tier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tier_seq")
    @SequenceGenerator(name = "tier_seq", sequenceName = "tier_seq", allocationSize = 1)
    private int id; 

    private String name;
    private String color;
    private int tableOrder;

    //関連が切れたオブジェクトを削除する（orphanRemoval=true）とした場合、別のTierに移動したオブジェクトが削除されることがある。
    //そのためorphanRemoval=falseとする。
    //その場合Listから削除されたHeroEvaluationが残ってしまうので、データベース上から対象を削除するUPDATE文を発行する。
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=false, fetch = FetchType.EAGER,mappedBy = "tier") 
    @OrderBy("evaluationOrder") //配列のソート順　@see http://terasolunaorg.github.io/guideline/public_review/ArchitectureInDetail/DataAccessJpa.html#id84
    private Set<HeroEvaluation> heroEvaluations = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "tiertableid")
    private TierTable tierTable;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public int getTableOrder() {
        return tableOrder;
    }
    public TierTable getTierTable() {
        return tierTable;
    }
    public void setTierTable(TierTable tierTable) {
        this.tierTable = tierTable;
    }
    public void setTableOrder(int tableOrder) {
        this.tableOrder = tableOrder;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    /** 
     * Tierに、指定したHeroEvaluationと同一のHeroEvaluationが、登録されているかを返却する。
     * なお同一性は、HeroEvaluationが保持するHeroで判定する。
     * @param heroEvaluation
     * @return boolean
     */
    public boolean containsHeroEvaluationByHero(HeroEvaluation heroEvaluation){
        return this.heroEvaluations.stream().
            filter(he->he.getHero().getId() == heroEvaluation.getHero().getId()).
            findFirst().
            isPresent();
    }

    public Set<HeroEvaluation> getHeroEvaluation() {
        return heroEvaluations;
    }

    public void setHeroEvaluation(Set<HeroEvaluation> heroEvaluation) {
        this.heroEvaluations = heroEvaluation;
        heroEvaluation.forEach(he->{
            he.setTier(this);
        });
    }

    public void addHeroEvaluation(HeroEvaluation heroEvaluation) {
        this.heroEvaluations.add(heroEvaluation);
        heroEvaluation.setTier(this);
    }

    public void removeHeroEvaluation(HeroEvaluation heroEvaluation) {
        this.heroEvaluations.remove(heroEvaluation);
        heroEvaluation.setTier(this);
    }

}


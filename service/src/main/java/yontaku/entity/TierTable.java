package yontaku.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@SqlResultSetMapping(name = "TierTablePagingDtoMapping", classes = {
        @ConstructorResult(targetClass = yontaku.entity.dto.TierTablePagingDto.class, columns = {
                @ColumnResult(name = "id", type = Integer.class), 
                @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "ownerid", type = Integer.class),
                @ColumnResult(name = "ownerName", type = String.class),
                @ColumnResult(name = "updatedAt", type = LocalDateTime.class) }) })
public class TierTable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tiertable_seq")
    @SequenceGenerator(name = "tiertable_seq", sequenceName = "tiertable_seq", allocationSize = 1)
    private Integer id;
    private String name;
    // FIXME One-To-Oneで結合する。Mapperに影響が及ぶのでいったんクエリで対応する。
    private int ownerid;

    @Column(columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private List<Tier> tiers = new ArrayList<>();

    private LocalDateTime updatedAt;

    public TierTable() {
    }

    public TierTable(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TierTable(Integer id, String name, int ownerid, List<Tier> tiers) {
        this.id = id;
        this.name = name;
        this.ownerid = ownerid;
        this.tiers = tiers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public List<Tier> getTiers() {
        return tiers;
    }

    public void setTiers(List<Tier> tiers) {
        this.tiers = tiers;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}

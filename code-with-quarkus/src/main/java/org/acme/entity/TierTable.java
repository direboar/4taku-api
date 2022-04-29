package org.acme.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class TierTable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tiertable_seq")
    @SequenceGenerator(name = "tiertable_seq", sequenceName = "tiertable_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private int ownerid;

    @Column(columnDefinition = "jsonb")    
    @Type(type = "jsonb")
    private List<Tier> tiers = new ArrayList<>();

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

}

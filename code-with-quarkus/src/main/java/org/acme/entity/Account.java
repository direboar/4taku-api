package org.acme.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    private String oicdUserName;
    private String name;
    private Integer tierTableId;

    public String getOicdUserName() {
        return oicdUserName;
    }
    public void setOicdUserName(String oicdUserName) {
        this.oicdUserName = oicdUserName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getTierTableId() {
        return tierTableId;
    }
    public void setTierTableId(Integer tierTableId) {
        this.tierTableId = tierTableId;
    }

}

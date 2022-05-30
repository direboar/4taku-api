package yontaku.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "heroid_seq")
    @SequenceGenerator(name = "heroid_seq", sequenceName = "heroid_seq", allocationSize = 1)
    private int id;

    private int battlenetId;
    private String name;
    private String displayName;
    private String imageURL;
    private Boolean invalid;

    public Hero() {
    }

    public Hero(int battlenetId, String name, String displayName, String imageURL,Boolean invalid) {
        this.battlenetId = battlenetId;
        this.name = name;
        this.displayName = displayName;
        this.imageURL = imageURL;
        this.invalid = invalid;
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    public int getId() {
        return id;
    }

    public int getBattlenetId() {
        return battlenetId;
    }

    public void setBattlenetId(int battlenetId) {
        this.battlenetId = battlenetId;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}

package yontaku.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Hero implements Auditable{
    @Id
    private int id;

    private String name;
    private String displayName;
    private String imageURL;
    private Boolean invalid;
    private LocalDateTime updatedAt;

    //Eagerでとる場合はJOIN FETCHすること
    //@see https://terasolunaorg.github.io/guideline/public_review/ArchitectureInDetail/DataAccessJpa.html#join-fetch
    // @OneToOne(mappedBy="hero",fetch = FetchType.EAGER)
    @OneToOne(mappedBy="hero",fetch = FetchType.LAZY) //no cascade.
    private DeckTrackerHeroNameMapping deckTrackerHeroNameMapping;

    public Hero() {
    }

    public Hero(int id, String name, String displayName, String imageURL,Boolean invalid) {
        this.id = id;
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

    public DeckTrackerHeroNameMapping getDeckTrackerHeroNameMapping() {
        return deckTrackerHeroNameMapping;
    }

    public void setDeckTrackerHeroNameMapping(DeckTrackerHeroNameMapping deckTrackerHeroNameMapping) {
        this.deckTrackerHeroNameMapping = deckTrackerHeroNameMapping;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isSame(Hero hero){
        return hero.displayName.equals(this.displayName) &&
            hero.imageURL.equals(this.imageURL) &&
            hero.name.equals(this.name);
    }

}

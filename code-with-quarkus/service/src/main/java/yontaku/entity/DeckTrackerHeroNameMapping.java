package yontaku.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DeckTrackerHeroNameMapping {

    @Id
    private String deckTrackerHeroName;
    private String heroName;
    
    public String getDeckTrackerHeroName() {
        return deckTrackerHeroName;
    }
    public void setDeckTrackerHeroName(String deckTrackerHeroName) {
        this.deckTrackerHeroName = deckTrackerHeroName;
    }
    public String getHeroName() {
        return heroName;
    }
    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

}


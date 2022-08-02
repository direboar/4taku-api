package yontaku.rest.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString
public class TierTableRestView{
    private Integer id;
    private String name;
    private int ownerid;
    private List<Tier> tiers = new ArrayList<>();

    @Getter 
    @Setter 
    @ToString
    public static class Tier{
        private String id; //uuid 
        private String name;
        private String color;
        private int tableOrder;
        private List<Hero> heros = new ArrayList<>();
    }

    @Getter 
    @Setter 
    @ToString
    public static class Hero{
        private String deckTrackerHeroName;
        private int id;//ヒーローのID
        private int evaluationId;//ヒーロー評価のID
        private String name;
        private String displayName;
        private String imageURL;
        private int evaluationOrder;
        private Ban ban;
        private String memo;
        private String linkName;
        private String linkUrl;
    }

    @Getter 
    @Setter 
    @ToString
    public static class Ban{
        private List<MinionType> required = new ArrayList<>();
        private List<MinionType> desierd = new ArrayList<>();
        private List<MinionType> needless = new ArrayList<>();
    }

    @Getter 
    @Setter 
    @ToString
    public static class MinionType{
        private int id;
        private String name;
        private String imageURL;
    }

}


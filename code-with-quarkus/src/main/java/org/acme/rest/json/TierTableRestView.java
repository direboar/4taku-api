package org.acme.rest.json;

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
        private List<Hero> heros = new ArrayList<>();
    }

    @Getter 
    @Setter 
    @ToString
    public static class Hero{
        private int id;
        private int battlenetId;
        private String name;
        private String displayName;
        private String imageURL;
        private Ban ban;

    }

    @Getter 
    @Setter 
    @ToString
    public static class Ban{
        private List<MinionType> exists;
        private List<MinionType> notExists;

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


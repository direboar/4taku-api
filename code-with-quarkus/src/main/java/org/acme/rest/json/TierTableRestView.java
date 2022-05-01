package org.acme.rest.json;

import java.util.ArrayList;
import java.util.List;

public class TierTableRestView{
    private Integer id;
    private String name;
    private int ownerid;
    private List<Tier> tiers = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public static class Tier{

        private String id; //uuid 
        private String name;
        private String color;
        private List<Hero> heros = new ArrayList<>();
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
        public List<Hero> getHeros() {
            return heros;
        }
        public void setHeros(List<Hero> heros) {
            this.heros = heros;
        }
    }

    public static class Hero{
        private int id;
        private int battlenetId;
        private String name;
        private String displayName;
        private String imageURL;

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public int getBattlenetId() {
            return battlenetId;
        }
        public void setBattlenetId(int battlenetId) {
            this.battlenetId = battlenetId;
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
        public Ban getBan() {
            return ban;
        }
        public void setBan(Ban ban) {
            this.ban = ban;
        }
        private Ban ban;

    }

    public static class Ban{
        private List<String> exists ;
        private List<String> notExists ;
        public List<String> getExists() {
            return exists;
        }
        public void setExists(List<String> exists) {
            this.exists = exists;
        }
        public List<String> getNotExists() {
            return notExists;
        }
        public void setNotExists(List<String> notExists) {
            this.notExists = notExists;
        }

    }

}


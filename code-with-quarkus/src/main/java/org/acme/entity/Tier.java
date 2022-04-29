package org.acme.entity;

import java.util.ArrayList;
import java.util.List;

public class Tier {
    private String id; //uuid 
    private String name;
    private String color;

    //永続化しない
    private List<Hero> heros = new ArrayList<>();

    //永続化対象
    private List<TieredHero> tieredHero = new ArrayList<>();

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
    public List<TieredHero> getTieredHero() {
        return tieredHero;
    }
    public void setTieredHero(List<TieredHero> tieredHero) {
        this.tieredHero = tieredHero;
    }

}


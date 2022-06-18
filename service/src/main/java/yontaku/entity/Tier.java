package yontaku.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString
public class Tier {
    private String id; //uuid 
    private String name;
    private String color;
    private int order;

    private List<Hero> heros = new ArrayList<>();

    @Getter 
    @Setter 
    @ToString
    public static class Hero{
        private int id;
        private Ban ban;
        private String memo;
    }

    @Getter 
    @Setter 
    @ToString
    public static class Ban{
        private List<String> exists ;
        private List<String> notExists ;

    }

}


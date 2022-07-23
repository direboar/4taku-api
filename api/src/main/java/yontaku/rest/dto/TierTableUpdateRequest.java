package yontaku.rest.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString
public class TierTableUpdateRequest {
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
        private int id;//ヒーローのID
        private int evaluationId;//ヒーロー評価のID
        private int evaluationOrder;
        private Ban ban;
        private String memo;
        private String heroMemoURL;
    }

    @Getter 
    @Setter 
    @ToString
    public static class Ban{
        private List<Integer> required ;
        private List<Integer> desierd ;
        private List<Integer> needless ;
    }

}


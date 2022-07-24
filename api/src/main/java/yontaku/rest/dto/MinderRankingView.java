package yontaku.rest.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MinderRankingView {
    private String minderRankingHeroName;
    private String ranking;
    private String coinCurve1;
    private String coinCurve2;
    private List<MinderRankingDetail> details;

    private String name;
    private String displayName;
    private String imageURL;

    private String deckTrackerHeroName;

    @Getter
    @Setter
    @ToString
    public static class MinderRankingDetail {
        private String minionType;
        private String ranking;
    }
    
}

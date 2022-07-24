package yontaku.rest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HeroRestView {
    private int id;
    private String name;
    private String displayName;
    private String imageURL;

}

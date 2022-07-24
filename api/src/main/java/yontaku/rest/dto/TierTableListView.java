package yontaku.rest.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TierTableListView {
    private Integer id;
    private String name;
    private Integer ownerid;
    private String ownerName;
    private LocalDateTime updatedAt;
    
}

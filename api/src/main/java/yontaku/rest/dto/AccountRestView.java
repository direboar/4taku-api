package yontaku.rest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString
public class AccountRestView {
    private int id;
    private String name;
    private String tierTableName;
    private Integer tierTableId;
    private boolean evaluateByMinderRanking;

}

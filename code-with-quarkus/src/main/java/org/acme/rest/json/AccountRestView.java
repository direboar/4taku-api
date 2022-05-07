package org.acme.rest.json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString
public class AccountRestView {
    private String oicdUserName;
    private String name;
    private String tierTableName;
    private Integer tierTableId;

}

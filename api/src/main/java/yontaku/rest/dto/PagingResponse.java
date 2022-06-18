package yontaku.rest.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString
public class PagingResponse<T> {
    
    private List<T> entity;
    private int totalCount;
    public PagingResponse(List<T> entity, int totalCount) {
        this.entity = entity;
        this.totalCount = totalCount;
    }
    
}

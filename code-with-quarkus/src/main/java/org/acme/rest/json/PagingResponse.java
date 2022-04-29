package org.acme.rest.json;

import java.util.List;

public class PagingResponse<T> {
    
    private List<T> entity;
    private int totalCount;
    public PagingResponse(List<T> entity, int totalCount) {
        this.entity = entity;
        this.totalCount = totalCount;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public List<T> getEntity() {
        return entity;
    }
    public void setEntity(List<T> entity) {
        this.entity = entity;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}

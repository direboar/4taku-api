package org.acme.entity.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TierTablePagingDto {
    private Integer id;
    private String name;
    private Integer ownerid;
    private String ownerName;
    private LocalDateTime updatedAt;

}

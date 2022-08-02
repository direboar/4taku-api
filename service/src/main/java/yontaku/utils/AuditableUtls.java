package yontaku.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import yontaku.entity.Auditable;

public final class AuditableUtls {
    
    public static final void updateTimestamp(Auditable auditable){
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        LocalDateTime updatedAt = now.toLocalDateTime();
        auditable.setUpdatedAt(updatedAt);
    }
   
}

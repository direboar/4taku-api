package yontaku.entity;

import java.time.LocalDateTime;

public interface Auditable {

    LocalDateTime getUpdatedAt();

    void setUpdatedAt(LocalDateTime updatedAt);

}

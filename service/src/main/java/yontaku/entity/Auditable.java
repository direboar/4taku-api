package yontaku.entity;

import java.time.LocalDateTime;

/**
 * 監査情報を保持することを表すインタフェース。
 */
public interface Auditable {

    /**
     * 最終更新時刻を取得する
     * @return
     */
    LocalDateTime getUpdatedAt();

    void setUpdatedAt(LocalDateTime updatedAt);

}

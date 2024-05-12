package com.entity;

import java.util.Date;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class EntityListener {
    @PrePersist
    public void prePersist(BaseEntity entity) {
        Date now = new Date();
        entity.setCreateDate(now);
    }

    @PreUpdate
    public void preUpdate(BaseEntity entity) {
        Date now = new Date();
        entity.setLastUpdateDate(now);
    }
}

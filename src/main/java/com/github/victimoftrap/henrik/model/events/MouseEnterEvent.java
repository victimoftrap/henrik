package com.github.victimoftrap.henrik.model.events;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "mouse_enter_events")
public class MouseEnterEvent {
    @Id
    @Column(name = "id", unique = true)
    @Type(type = "pg-uuid")
    private UUID id;

    public MouseEnterEvent() {
    }

    public MouseEnterEvent(final UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}

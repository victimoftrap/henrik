package com.github.victimoftrap.henrik.model.events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "mouse_leave_events")
public class MouseLeaveEvent {
    @Id
    @Column(name = "id", unique = true)
    private UUID id;

    public MouseLeaveEvent() {
    }

    public MouseLeaveEvent(final UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}

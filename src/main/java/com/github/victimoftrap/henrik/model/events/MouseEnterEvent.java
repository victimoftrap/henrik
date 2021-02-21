package com.github.victimoftrap.henrik.model.events;

import com.github.victimoftrap.henrik.model.EventDescription;
import com.github.victimoftrap.henrik.model.EventType;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name = "mouse_enter_events")
public class MouseEnterEvent extends EventDescription {
    @Column(name = "id", unique = true)
    @Type(type = "pg-uuid")
    private UUID eventId;

    public MouseEnterEvent() {
    }

    public MouseEnterEvent(final UUID id,
                           final long contestId,
                           final long userId,
                           final ZonedDateTime createdAt,
                           final EventType type,
                           final UUID eventId) {
        super(id, contestId, userId, createdAt, type, eventId);
        this.eventId = eventId;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(final UUID eventId) {
        this.eventId = eventId;
    }
}

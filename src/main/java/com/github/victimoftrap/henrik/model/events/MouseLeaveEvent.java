package com.github.victimoftrap.henrik.model.events;

import com.github.victimoftrap.henrik.model.EventDescription;
import com.github.victimoftrap.henrik.model.EventType;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name = "mouse_leave_events")
public class MouseLeaveEvent extends EventDescription {
    @Id
    @Column(name = "event_id", unique = true)
    private UUID eventId;

    public MouseLeaveEvent() {
    }

    public MouseLeaveEvent(final UUID id,
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

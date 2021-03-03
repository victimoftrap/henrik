package com.github.victimoftrap.henrik.model.events;

import com.github.victimoftrap.henrik.model.EventDescription;
import com.github.victimoftrap.henrik.model.EventType;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "mouse_leave_events")
public class MouseLeaveEvent extends EventDescription {
    public MouseLeaveEvent() {
    }

    public MouseLeaveEvent(final UUID id,
                           final long contestId,
                           final long userId,
                           final ZonedDateTime createdAt,
                           final EventType type) {
        super(id, contestId, userId, createdAt, type);
    }
}

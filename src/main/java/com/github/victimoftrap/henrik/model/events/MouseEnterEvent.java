package com.github.victimoftrap.henrik.model.events;

import com.github.victimoftrap.henrik.model.EventDescription;
import com.github.victimoftrap.henrik.model.EventType;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "mouse_enter_events")
public class MouseEnterEvent extends EventDescription {
    public MouseEnterEvent() {
    }

    public MouseEnterEvent(final UUID id,
                           final long contestId,
                           final long userId,
                           final String userLogin,
                           final ZonedDateTime createdAt,
                           final EventType type) {
        super(id, contestId, userId, userLogin, createdAt, type);
    }
}

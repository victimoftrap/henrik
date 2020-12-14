package com.github.victimoftrap.mikael.model.events;

import com.github.victimoftrap.mikael.model.EventType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "event_descriptions")
public class EventDescription {
    @Id
    @Column(name = "id", unique = true)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "contest_id")
    private long contestId;

    @Column(name = "user_id")
    private long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private EventType type;

    @Column(name = "event_id", unique = true)
    @Type(type = "pg-uuid")
    private UUID eventId;

    public EventDescription() {
    }

    public EventDescription(final UUID id,
                            final long contestId,
                            final long userId,
                            final EventType type,
                            final UUID eventId) {
        this.id = id;
        this.contestId = contestId;
        this.userId = userId;
        this.type = type;
        this.eventId = eventId;
    }

    public UUID getId() {
        return id;
    }

    public long getContestId() {
        return contestId;
    }

    public long getUserId() {
        return userId;
    }

    public EventType getType() {
        return type;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setContestId(long contestId) {
        this.contestId = contestId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }
}

package com.github.victimoftrap.henrik.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "event_descriptions")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EventDescription {
    @Id
    @Column(name = "id", unique = true)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "contest_id")
    private long contestId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

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
                            final ZonedDateTime createdAt,
                            final EventType type,
                            final UUID eventId) {
        this.id = id;
        this.contestId = contestId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.type = type;
        this.eventId = eventId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public long getContestId() {
        return contestId;
    }

    public void setContestId(final long contestId) {
        this.contestId = contestId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public EventType getType() {
        return type;
    }

    public void setType(final EventType type) {
        this.type = type;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(final UUID eventId) {
        this.eventId = eventId;
    }
}

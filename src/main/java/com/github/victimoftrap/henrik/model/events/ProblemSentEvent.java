package com.github.victimoftrap.henrik.model.events;

import com.github.victimoftrap.henrik.model.EventDescription;
import com.github.victimoftrap.henrik.model.EventType;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "problem_sent_events")
public class ProblemSentEvent extends EventDescription {
    @Column(name = "id", unique = true)
    @Type(type = "pg-uuid")
    private UUID eventId;

    @Column(name = "title")
    private String title;

    public ProblemSentEvent() {
    }

    public ProblemSentEvent(final UUID id,
                            final long contestId,
                            final long userId,
                            final ZonedDateTime createdAt,
                            final EventType type,
                            final UUID eventId,
                            final String title) {
        super(id, contestId, userId, createdAt, type, eventId);
        this.eventId = eventId;
        this.title = title;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(final UUID eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
}

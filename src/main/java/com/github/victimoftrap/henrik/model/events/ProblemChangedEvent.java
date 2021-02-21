package com.github.victimoftrap.henrik.model.events;

import com.github.victimoftrap.henrik.model.EventDescription;
import com.github.victimoftrap.henrik.model.EventType;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name = "problem_changed_events")
public class ProblemChangedEvent extends EventDescription {
    @Id
    @Column(name = "event_id", unique = true)
    @Type(type = "pg-uuid")
    private UUID eventId;

    @Column(name = "prev_problem_title")
    private String title;

    @Column(name = "prev_problem_url")
    private String url;

    public ProblemChangedEvent() {
    }

    public ProblemChangedEvent(final UUID id,
                               final long contestId,
                               final long userId,
                               final ZonedDateTime createdAt,
                               final EventType type,
                               final UUID eventId,
                               final String title,
                               final String url) {
        super(id, contestId, userId, createdAt, type, eventId);
        this.eventId = eventId;
        this.title = title;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }
}

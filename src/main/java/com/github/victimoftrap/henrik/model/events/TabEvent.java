package com.github.victimoftrap.henrik.model.events;

import com.github.victimoftrap.henrik.model.EventDescription;
import com.github.victimoftrap.henrik.model.EventType;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name = "tab_events")
public class TabEvent extends EventDescription {
    @Id
    @Column(name = "event_id", unique = true)
    @Type(type = "pg-uuid")
    private UUID eventId;

    @Column(name = "url")
    private String url;

    @Column(name = "active")
    private boolean active;

    @Column(name = "incognito")
    private boolean incognito;

    public TabEvent() {
    }

    public TabEvent(final UUID id,
                    final long contestId,
                    final long userId,
                    final ZonedDateTime createdAt,
                    final EventType type,
                    final UUID eventId,
                    final String url,
                    final boolean active,
                    final boolean incognito) {
        super(id, contestId, userId, createdAt, type, eventId);
        this.eventId = eventId;
        this.url = url;
        this.active = active;
        this.incognito = incognito;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(final UUID eventId) {
        this.eventId = eventId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

    public boolean isIncognito() {
        return incognito;
    }

    public void setIncognito(final boolean incognito) {
        this.incognito = incognito;
    }
}

package com.github.victimoftrap.henrik.model.events;

import com.github.victimoftrap.henrik.model.EventDescription;
import com.github.victimoftrap.henrik.model.EventType;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tab_events")
public class TabEvent extends EventDescription {
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
                    final String userLogin,
                    final ZonedDateTime createdAt,
                    final EventType type,
                    final String url,
                    final boolean active,
                    final boolean incognito) {
        super(id, contestId, userId, userLogin, createdAt, type);
        this.url = url;
        this.active = active;
        this.incognito = incognito;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TabEvent tabEvent = (TabEvent) o;
        return active == tabEvent.active
                && incognito == tabEvent.incognito
                && Objects.equals(url, tabEvent.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), url, active, incognito);
    }

    @Override
    public String toString() {
        return "TabEvent{" +
                "url='" + url + '\'' +
                ", active=" + active +
                ", incognito=" + incognito +
                '}';
    }
}

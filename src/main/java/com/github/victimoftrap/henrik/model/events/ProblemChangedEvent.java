package com.github.victimoftrap.henrik.model.events;

import com.github.victimoftrap.henrik.model.EventDescription;
import com.github.victimoftrap.henrik.model.EventType;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "problem_changed_events")
public class ProblemChangedEvent extends EventDescription {
    @Column(name = "prev_title")
    private String title;

    @Column(name = "prev_url")
    private String url;

    public ProblemChangedEvent() {
    }

    public ProblemChangedEvent(final UUID id,
                               final long contestId,
                               final long userId,
                               final ZonedDateTime createdAt,
                               final EventType type,
                               final String title,
                               final String url) {
        super(id, contestId, userId, createdAt, type);
        this.title = title;
        this.url = url;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProblemChangedEvent that = (ProblemChangedEvent) o;
        return Objects.equals(title, that.title) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, url);
    }

    @Override
    public String toString() {
        return "ProblemChangedEvent{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

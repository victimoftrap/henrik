package com.github.victimoftrap.henrik.model.events;

import com.github.victimoftrap.henrik.model.EventDescription;
import com.github.victimoftrap.henrik.model.EventType;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "problem_sent_events")
public class ProblemSentEvent extends EventDescription {
    @Column(name = "title")
    private String title;

    public ProblemSentEvent() {
    }

    public ProblemSentEvent(final UUID id,
                            final long contestId,
                            final long userId,
                            final ZonedDateTime createdAt,
                            final EventType type,
                            final String title) {
        super(id, contestId, userId, createdAt, type);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProblemSentEvent that = (ProblemSentEvent) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title);
    }

    @Override
    public String toString() {
        return "ProblemSentEvent{" +
                "title='" + title + '\'' +
                '}';
    }
}

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
    private String problemTitle;

    @Column(name = "prev_id")
    private String problemId;

    @Column(name = "prev_url")
    private String url;

    public ProblemChangedEvent() {
    }

    public ProblemChangedEvent(final UUID id,
                               final long contestId,
                               final long userId,
                               final String userLogin,
                               final ZonedDateTime createdAt,
                               final EventType type,
                               final String problemId,
                               final String problemTitle,
                               final String problemUrl) {
        super(id, contestId, userId, userLogin, createdAt, type);
        this.problemId = problemId;
        this.problemTitle = problemTitle;
        this.url = problemUrl;
    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(final String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(final String problemId) {
        this.problemId = problemId;
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
        return Objects.equals(problemId, that.problemId)
                && Objects.equals(problemTitle, that.problemTitle)
                && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), problemId, problemTitle, url);
    }

    @Override
    public String toString() {
        return "ProblemChangedEvent{" +
                "problemTitle='" + problemTitle + '\'' +
                ", problemId='" + problemId + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

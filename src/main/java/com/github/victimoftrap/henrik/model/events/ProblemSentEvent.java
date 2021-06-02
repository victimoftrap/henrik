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
    @Column(name = "problem_id")
    private String problemId;

    @Column(name = "problem_title")
    private String title;

    @Column(name = "problem_url")
    private String problemUrl;

    public ProblemSentEvent() {
    }

    public ProblemSentEvent(final UUID id,
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
        this.title = problemTitle;
        this.problemUrl = problemUrl;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(final String problemId) {
        this.problemId = problemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getProblemUrl() {
        return problemUrl;
    }

    public void setProblemUrl(final String problemUrl) {
        this.problemUrl = problemUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProblemSentEvent that = (ProblemSentEvent) o;
        return Objects.equals(problemId, that.problemId)
                && Objects.equals(title, that.title)
                && Objects.equals(problemUrl, that.problemUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), problemId, title, problemUrl);
    }

    @Override
    public String toString() {
        return "ProblemSentEvent{" +
                "problemId='" + problemId + '\'' +
                ", title='" + title + '\'' +
                ", problemUrl='" + problemUrl + '\'' +
                '}';
    }
}

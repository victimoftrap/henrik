package com.github.victimoftrap.henrik.model.events;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "problem_changed_events")
public class ProblemChangedEvent {
    @Id
    @Column(name = "id", unique = true)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    public ProblemChangedEvent() {
    }

    public ProblemChangedEvent(final UUID id, final String title, final String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

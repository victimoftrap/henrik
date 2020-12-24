package com.github.victimoftrap.henrik.model.events;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "tab_events")
public class TabEvent {
    @Id
    @Column(name = "id", unique = true)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "url")
    private String url;

    @Column(name = "active")
    private boolean active;

    @Column(name = "incognito")
    private boolean incognito;

    public TabEvent() {
    }

    public TabEvent(final UUID id, final String url, final boolean active, final boolean incognito) {
        this.id = id;
        this.url = url;
        this.active = active;
        this.incognito = incognito;
    }

    public UUID getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isIncognito() {
        return incognito;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setIncognito(boolean incognito) {
        this.incognito = incognito;
    }
}

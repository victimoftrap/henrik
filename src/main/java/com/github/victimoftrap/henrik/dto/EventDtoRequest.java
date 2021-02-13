package com.github.victimoftrap.henrik.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class EventDtoRequest {
    private long contestId;
    private long userId;
    private String type;
    private JsonNode event;

    public EventDtoRequest() {
    }

    @JsonCreator
    public EventDtoRequest(
            @JsonProperty("contestId") final long contestId,
            @JsonProperty("userId") final long userId,
            @JsonProperty("type") final String type,
            @JsonProperty("event") final JsonNode event) {
        this.contestId = contestId;
        this.userId = userId;
        this.type = type;
        this.event = event;
    }

    public long getContestId() {
        return contestId;
    }

    public long getUserId() {
        return userId;
    }

    public String getType() {
        return type;
    }

    public JsonNode getEvent() {
        return event;
    }
}

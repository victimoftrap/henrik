package com.github.victimoftrap.henrik.dto;

import com.github.victimoftrap.henrik.validation.ValidEventType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import javax.validation.constraints.NotBlank;

public class EventDtoRequest {
    private long contestId;

    @NotBlank
    private String userId;

    @NotBlank
    private String userLogin;

    @NotBlank
    private String createdAt;

    @ValidEventType
    private String type;
    private JsonNode event;

    public EventDtoRequest() {
    }

    @JsonCreator
    public EventDtoRequest(
            @JsonProperty("contestId") final long contestId,
            @JsonProperty("userId") final String userId,
            @JsonProperty("userLogin") final String userLogin,
            @JsonProperty("createdAt") final String createdAt,
            @JsonProperty("type") final String type,
            @JsonProperty("event") final JsonNode event) {
        this.contestId = contestId;
        this.userId = userId;
        this.userLogin = userLogin;
        this.createdAt = createdAt;
        this.type = type;
        this.event = event;
    }

    public long getContestId() {
        return contestId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getType() {
        return type;
    }

    public JsonNode getEvent() {
        return event;
    }
}

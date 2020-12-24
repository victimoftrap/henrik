package com.github.victimoftrap.henrik.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class EventDtoRequest {
    private String type;
    private JsonNode event;

    public EventDtoRequest() {
    }

    @JsonCreator
    public EventDtoRequest(
            @JsonProperty("type") final String type,
            @JsonProperty("event") final JsonNode event) {
        this.type = type;
        this.event = event;
    }

    public String getType() {
        return type;
    }

    public JsonNode getEvent() {
        return event;
    }
}

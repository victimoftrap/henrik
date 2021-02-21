package com.github.victimoftrap.henrik.service;

import com.github.victimoftrap.henrik.dto.EventDtoRequest;
import com.github.victimoftrap.henrik.model.EventDescription;
import com.github.victimoftrap.henrik.model.EventType;
import com.github.victimoftrap.henrik.model.events.*;
import com.github.victimoftrap.henrik.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service("EventService")
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(final EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void saveEvent(final EventDtoRequest eventDtoRequest) {
        final var eventType = EventType.valueOf(eventDtoRequest.getType());
        final var eventJsonNode = eventDtoRequest.getEvent();

        var contestId = eventDtoRequest.getContestId();
        var userId = Long.parseLong(eventDtoRequest.getUserId());
        var createdAt = ZonedDateTime.parse(
                eventDtoRequest.getCreatedAt(),
                DateTimeFormatter.ISO_ZONED_DATE_TIME
        );

        EventDescription description = null;
        if (eventType == EventType.TAB_EVENT) {
            description = new TabEvent(
                    UUID.randomUUID(),
                    contestId,
                    userId,
                    createdAt,
                    EventType.TAB_EVENT,
                    UUID.randomUUID(),
                    eventJsonNode.get("url").asText(),
                    eventJsonNode.get("active").asBoolean(),
                    eventJsonNode.get("incognito").asBoolean()
            );
        }
        if (eventType == EventType.MOUSE_ENTER_EVENT) {
            description = new MouseEnterEvent(
                    UUID.randomUUID(),
                    contestId,
                    userId,
                    createdAt,
                    EventType.MOUSE_ENTER_EVENT,
                    UUID.randomUUID()
            );
        }
        if (eventType == EventType.MOUSE_LEAVE_EVENT) {
            description = new MouseLeaveEvent(
                    UUID.randomUUID(),
                    contestId,
                    userId,
                    createdAt,
                    EventType.MOUSE_LEAVE_EVENT,
                    UUID.randomUUID()
            );
        }
        if (eventType == EventType.PROBLEM_CHANGED_EVENT) {
            description = new ProblemChangedEvent(
                    UUID.randomUUID(),
                    contestId,
                    userId,
                    createdAt,
                    EventType.PROBLEM_CHANGED_EVENT,
                    UUID.randomUUID(),
                    eventJsonNode.get("prevProblemTitle").asText(),
                    eventJsonNode.get("prevProblemUrl").asText()
            );
        }
        if (eventType == EventType.PROBLEM_SENT_EVENT) {
            description = new ProblemSentEvent(
                    UUID.randomUUID(),
                    contestId,
                    userId,
                    createdAt,
                    EventType.PROBLEM_SENT_EVENT,
                    UUID.randomUUID(),
                    eventJsonNode.get("title").asText()
            );
        }
        eventRepository.save(description);
    }
}

package com.github.victimoftrap.henrik.commands;

import com.github.victimoftrap.henrik.dto.EventDtoRequest;
import com.github.victimoftrap.henrik.model.EventType;
import com.github.victimoftrap.henrik.model.events.TabEvent;
import com.github.victimoftrap.henrik.repository.EventRepository;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TabCommand implements ICommand {
    private final EventRepository eventRepository;

    public TabCommand(final EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void execute(final EventDtoRequest request) {
        var userId = Long.parseLong(request.getUserId());
        var createdAt = ZonedDateTime.parse(
                request.getCreatedAt(),
                DateTimeFormatter.ISO_ZONED_DATE_TIME
        );
        var eventJsonNode = request.getEvent();

        var tabEvent = new TabEvent(
                UUID.randomUUID(),
                request.getContestId(),
                userId,
                createdAt,
                EventType.TAB_EVENT,
                eventJsonNode.get("url").asText(),
                eventJsonNode.get("active").asBoolean(),
                eventJsonNode.get("incognito").asBoolean()
        );
        eventRepository.save(tabEvent);
    }
}

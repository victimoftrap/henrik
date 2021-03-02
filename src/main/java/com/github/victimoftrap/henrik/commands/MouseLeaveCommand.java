package com.github.victimoftrap.henrik.commands;

import com.github.victimoftrap.henrik.dto.EventDtoRequest;
import com.github.victimoftrap.henrik.model.EventType;
import com.github.victimoftrap.henrik.model.events.MouseLeaveEvent;
import com.github.victimoftrap.henrik.repository.EventRepository;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class MouseLeaveCommand implements ICommand {
    private final EventRepository eventRepository;

    public MouseLeaveCommand(final EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void execute(final EventDtoRequest request) {
        var userId = Long.parseLong(request.getUserId());
        var createdAt = ZonedDateTime.parse(
                request.getCreatedAt(),
                DateTimeFormatter.ISO_ZONED_DATE_TIME
        );
        var mainEvent = new MouseLeaveEvent(
                UUID.randomUUID(),
                request.getContestId(),
                userId,
                createdAt,
                EventType.MOUSE_LEAVE_EVENT,
                UUID.randomUUID()
        );
        eventRepository.save(mainEvent);
    }
}

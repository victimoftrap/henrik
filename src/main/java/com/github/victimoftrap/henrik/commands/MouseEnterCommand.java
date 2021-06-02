package com.github.victimoftrap.henrik.commands;

import com.github.victimoftrap.henrik.dto.EventDtoRequest;
import com.github.victimoftrap.henrik.model.EventType;
import com.github.victimoftrap.henrik.model.events.MouseEnterEvent;
import com.github.victimoftrap.henrik.repository.EventRepository;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class MouseEnterCommand implements ICommand {
    private final EventRepository eventRepository;

    public MouseEnterCommand(final EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void execute(final EventDtoRequest request) {
        var userId = Long.parseLong(request.getUserId());
        var createdAt = ZonedDateTime.parse(
                request.getCreatedAt(),
                DateTimeFormatter.ISO_ZONED_DATE_TIME
        );
        var mouseEvent = new MouseEnterEvent(
                UUID.randomUUID(),
                request.getContestId(),
                userId,
                request.getUserLogin(),
                createdAt,
                EventType.MOUSE_ENTER_EVENT
        );
        eventRepository.save(mouseEvent);
    }
}

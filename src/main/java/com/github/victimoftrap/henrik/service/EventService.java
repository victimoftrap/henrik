package com.github.victimoftrap.henrik.service;

import com.github.victimoftrap.henrik.commands.ICommand;
import com.github.victimoftrap.henrik.dto.EventDtoRequest;
import com.github.victimoftrap.henrik.model.EventType;
import com.github.victimoftrap.henrik.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("EventService")
public class EventService {
    private final EventRepository eventRepository;
    private final Map<EventType, ICommand> eventCommands;

    @Autowired
    public EventService(
            final EventRepository eventRepository,
            @Qualifier("eventCommands") final Map<EventType, ICommand> eventCommands) {
        this.eventRepository = eventRepository;
        this.eventCommands = eventCommands;
    }

    public void saveEvent(final EventDtoRequest eventDtoRequest) {
        final var eventType = EventType.valueOf(eventDtoRequest.getType());
        final var activeCommand = eventCommands.get(eventType);
        activeCommand.execute(eventDtoRequest);
    }
}

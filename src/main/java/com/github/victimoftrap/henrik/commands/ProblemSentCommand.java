package com.github.victimoftrap.henrik.commands;

import com.github.victimoftrap.henrik.dto.EventDtoRequest;
import com.github.victimoftrap.henrik.model.EventType;
import com.github.victimoftrap.henrik.model.events.ProblemSentEvent;
import com.github.victimoftrap.henrik.repository.EventRepository;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ProblemSentCommand implements ICommand {
    private final EventRepository eventRepository;

    public ProblemSentCommand(final EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void execute(final EventDtoRequest request) {
        var userId = Long.parseLong(request.getUserId());
        var createdAt = ZonedDateTime.parse(
                request.getCreatedAt(),
                DateTimeFormatter.ISO_ZONED_DATE_TIME
        );
        var sentEvent = new ProblemSentEvent(
                UUID.randomUUID(),
                request.getContestId(),
                userId,
                request.getUserLogin(),
                createdAt,
                EventType.PROBLEM_SENT_EVENT,
                request.getEvent().get("problemId").asText(),
                request.getEvent().get("problemTitle").asText(),
                request.getEvent().get("problemUrl").asText()
        );
        eventRepository.save(sentEvent);
    }
}

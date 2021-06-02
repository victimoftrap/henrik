package com.github.victimoftrap.henrik.commands;

import com.github.victimoftrap.henrik.dto.EventDtoRequest;
import com.github.victimoftrap.henrik.model.EventType;
import com.github.victimoftrap.henrik.model.events.ProblemChangedEvent;
import com.github.victimoftrap.henrik.repository.EventRepository;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ProblemChangedCommand implements ICommand {
    private final EventRepository eventRepository;

    public ProblemChangedCommand(final EventRepository eventRepository) {
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

        var problemEvent = new ProblemChangedEvent(
                UUID.randomUUID(),
                request.getContestId(),
                userId,
                request.getUserLogin(),
                createdAt,
                EventType.PROBLEM_CHANGED_EVENT,
                eventJsonNode.get("prevProblemId").asText(),
                eventJsonNode.get("prevProblemTitle").asText(),
                eventJsonNode.get("prevProblemUrl").asText()
        );
        eventRepository.save(problemEvent);
    }
}

package com.github.victimoftrap.henrik.commands;

import com.github.victimoftrap.henrik.dto.EventDtoRequest;
import com.github.victimoftrap.henrik.model.EventType;
import com.github.victimoftrap.henrik.model.events.SolutionCodeSentEvent;
import com.github.victimoftrap.henrik.repository.EventRepository;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class SolutionCodeSentCommand implements ICommand {
    private final EventRepository eventRepository;

    public SolutionCodeSentCommand(final EventRepository eventRepository) {
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

        var solutionCodeEvent = new SolutionCodeSentEvent(
                UUID.randomUUID(),
                request.getContestId(),
                userId,
                createdAt,
                EventType.SOLUTION_CODE_SENT_EVENT,
                eventJsonNode.get("problemTitle").asText(),
                eventJsonNode.get("problemUrl").asText(),
                eventJsonNode.get("compiler").asText(),
                eventJsonNode.get("solutionType").asText(),
                eventJsonNode.get("source").asText()
        );
        eventRepository.save(solutionCodeEvent);
    }
}

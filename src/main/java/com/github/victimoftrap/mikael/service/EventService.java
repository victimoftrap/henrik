package com.github.victimoftrap.mikael.service;

import com.github.victimoftrap.mikael.dto.EventDtoRequest;
import com.github.victimoftrap.mikael.model.*;
import com.github.victimoftrap.mikael.model.events.*;
import com.github.victimoftrap.mikael.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("EventService")
public class EventService {
    private final MainEventRepository mainEventRepository;
    private final MouseEnterEventRepository mouseEnterEventRepository;
    private final MouseLeaveEventRepository mouseLeaveEventRepository;
    private final ProblemChangedEventRepository problemChangedEventRepository;
    private final ProblemSentEventRepository problemSentEventRepository;
    private final TabEventRepository tabEventRepository;

    @Autowired
    public EventService(final MainEventRepository mainEventRepository,
                        final MouseEnterEventRepository mouseEnterEventRepository,
                        final MouseLeaveEventRepository mouseLeaveEventRepository,
                        final ProblemChangedEventRepository problemChangedEventRepository,
                        final ProblemSentEventRepository problemSentEventRepository,
                        final TabEventRepository tabEventRepository) {
        this.mainEventRepository = mainEventRepository;
        this.mouseEnterEventRepository = mouseEnterEventRepository;
        this.mouseLeaveEventRepository = mouseLeaveEventRepository;
        this.problemChangedEventRepository = problemChangedEventRepository;
        this.problemSentEventRepository = problemSentEventRepository;
        this.tabEventRepository = tabEventRepository;
    }

    public void saveEvent(final EventDtoRequest eventDtoRequest) {
        final var eventType = EventType.valueOf(eventDtoRequest.getType());
        final var eventJsonNode = eventDtoRequest.getEvent();

        var mainEvent = new EventDescription(
                UUID.randomUUID(),
                0,
                0,
                eventType,
                UUID.randomUUID()
        );
        mainEventRepository.save(mainEvent);

        if (eventType == EventType.TAB_EVENT) {
            var tabEvent = new TabEvent(
                    mainEvent.getEventId(),
                    eventJsonNode.get("url").asText(),
                    eventJsonNode.get("active").asBoolean(),
                    eventJsonNode.get("incognito").asBoolean()
            );
            tabEventRepository.save(tabEvent);
        }
        if (eventType == EventType.MOUSE_ENTER_EVENT ) {
            var mouseEvent = new MouseEnterEvent(mainEvent.getEventId());
            mouseEnterEventRepository.save(mouseEvent);
        }
        if (eventType == EventType.MOUSE_LEAVE_EVENT ) {
            var mouseEvent = new MouseLeaveEvent(mainEvent.getEventId());
            mouseLeaveEventRepository.save(mouseEvent);
        }
        if (eventType == EventType.PROBLEM_CHANGED_EVENT) {
            var problemEvent = new ProblemChangedEvent(
                    mainEvent.getEventId(),
                    eventJsonNode.get("prevProblemTitle").asText(),
                    eventJsonNode.get("prevProblemUrl").asText()
            );
            problemChangedEventRepository.save(problemEvent);
        }
        if (eventType == EventType.PROBLEM_SENT_EVENT) {
            var sentEvent = new ProblemSentEvent(
                    mainEvent.getEventId(),
                    eventJsonNode.get("title").asText()
            );
            problemSentEventRepository.save(sentEvent);
        }
    }
}

package com.github.victimoftrap.henrik.controller;

import com.github.victimoftrap.henrik.dto.EventDtoRequest;
import com.github.victimoftrap.henrik.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(final EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping(
            value = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void saveEvent(final @RequestBody EventDtoRequest requestBody) {
        eventService.saveEvent(requestBody);
    }
}

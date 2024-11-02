package com.entjava.poker.controller;

import com.entjava.poker.model.Event;
import com.entjava.poker.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event/{id}")
    public Event events(@PathVariable Integer id) {
        return eventService.getEventById(id).orElse(null);
    }

}

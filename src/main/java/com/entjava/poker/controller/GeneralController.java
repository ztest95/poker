package com.entjava.poker.controller;

import com.entjava.poker.model.Event;
import com.entjava.poker.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GeneralController {

    @Autowired
    private final EventService eventService;

    public GeneralController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event/{id}")
    public Event events(@PathVariable Long id) {
        return eventService.getEventById(id).orElse(null);
    }

}

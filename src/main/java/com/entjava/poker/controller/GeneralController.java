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
    private EventService eventService;

    @GetMapping("/event/{id}")
    public Optional<Event> events(@PathVariable String id) {
        return eventService.getEventById(Long.valueOf(id));
//                .orElseThrow(() -> new RunTimeException("Event not found"));
    }

}

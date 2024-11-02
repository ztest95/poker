package com.entjava.poker.controller;

import com.entjava.poker.model.Player;
import com.entjava.poker.model.Event;
import com.entjava.poker.service.EventPlayerService;
import com.entjava.poker.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public Event events(@PathVariable Integer id) {
        return eventService.getEventById(id).orElse(null);
    }

    @GetMapping("/{id}/player")
    public Set<Player> players(@PathVariable Integer id) {
        return eventService.getPlayersByEventId(id);
    }

}

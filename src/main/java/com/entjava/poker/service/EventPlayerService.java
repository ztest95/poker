package com.entjava.poker.service;

import com.entjava.poker.model.Player;
import com.entjava.poker.model.Event;
import com.entjava.poker.model.EventPlayer;
import com.entjava.poker.repository.EventPlayerRepository;
import com.entjava.poker.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class EventPlayerService {

    @Autowired
    private EventPlayerRepository eventPlayerRepository;

    @Autowired
    private EventRepository eventRepository;

    public Set<EventPlayer> getPlayersByEventId(Integer id) {
        return eventPlayerRepository.findByEventId(id);
    }

    public Set<EventPlayer> getEventsByPlayerId(Integer id) {
        return eventPlayerRepository.findByPlayerId(id);
    }
    
}

package com.entjava.poker.service;

import com.entjava.poker.model.Event;
import com.entjava.poker.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Optional<Event> getEventById(Integer id) {
        return eventRepository.findById(id);
    }
}

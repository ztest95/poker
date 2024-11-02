package com.entjava.poker.repository;

import com.entjava.poker.model.EventPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface EventPlayerRepository extends JpaRepository<EventPlayer, Integer> {
    Set<EventPlayer> findByEventId(Integer eventId);
    Set<EventPlayer> findByPlayerId(Integer playerId);
}

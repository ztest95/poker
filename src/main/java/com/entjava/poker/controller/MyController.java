package com.entjava.poker.controller;

import com.entjava.poker.model.Event;
import com.entjava.poker.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;

import com.entjava.poker.service.EventService;
import com.entjava.poker.service.PlayerService;

@RestController
@RequestMapping("/test")
public class MyController {

    @Autowired
    private EventService eventService;

    @Autowired
    private PlayerService playerService;

    @GetMapping("/event/{id}")
    public ResponseEntity<?> events(@PathVariable Integer id) {
        Map<String, String> map = new HashMap<>();
//        Event event = eventService.getEventById(id).orElse(null);
//        if (event != null) {
//            Set<Player> player_objects = event.getPlayers();
//            StringBuilder players = new StringBuilder();
//            for (Player player : player_objects) {
//                players.append(player.getName()).append(", ");
//            }
//            if (players.length() > 0) {
//                players.setLength(players.length() - 2); // Remove the trailing comma and space
//            }
//            map.put("players", players.toString());
//            String winner = event.getWinnerPlayer() == null ? "No winner" : event.getWinnerPlayer().getName();
//            map.put("winner", winner);
//        } else {
//            map.put("players", "No players");
//            map.put("winner", "No winner");
//        }
        return ResponseEntity.ok(map);
    }
}

package com.entjava.poker.service;

import com.entjava.poker.model.Player;
import com.entjava.poker.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Optional<Player> getPlayerById(Integer id) {
        return playerRepository.findById(id);
    }
}

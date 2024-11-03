package com.entjava.poker.repository;

import com.entjava.poker.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByNameIn(List<String> names);
}

package com.entjava.poker.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    @JsonManagedReference
    @JoinTable(
            name="event_player",
            joinColumns = {
                    @JoinColumn(name = "event_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "player_id", referencedColumnName = "id")
            }
    )
    private Set<PlayerEntity> players = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<PlayerEntity> getPlayers() {
        return this.players;
    }

    public void setPlayers(Set<PlayerEntity> players) {
        this.players = players;
    }

}
